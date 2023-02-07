package com.techelevator.dao;

import com.techelevator.model.Exercise;
import com.techelevator.model.Workout;
import com.techelevator.model.WorkoutExercise;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JdbcWorkoutExerciseDao implements WorkoutExerciseDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcWorkoutExerciseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ArrayList<Workout> allWorkouts() {
        ArrayList<Workout> workouts = new ArrayList<>();
        String sql = "SELECT DISTINCT workout_name FROM workout_exercise";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Workout workout = new Workout();
            workout.setWorkout_name(results.getString("workout_name"));
            workouts.add(workout);
        }
        for (int i = 0; i < workouts.size(); i++) {
            ArrayList<Exercise> exercises = new ArrayList<>();
            String sql2 = "SELECT exercise FROM workout_exercise WHERE workout_name = ?";
            SqlRowSet results2 = jdbcTemplate.queryForRowSet(sql2, workouts.get(i).getWorkout_name());
            while (results2.next()) {
                String sql3 = "SELECT * FROM exercise WHERE exercise_id = ?";
                SqlRowSet results3 = jdbcTemplate.queryForRowSet(sql3, results2.getInt("exercise"));
                if (results3.next()) {
                    Exercise exercise = new Exercise();
                    exercise.setExercise_id(results3.getInt("exercise_id"));
                    exercise.setExercise_name(results3.getString("exercise_name"));
                    exercise.setExercise_description(results3.getString("exercise_description"));
                    exercise.setSuggested_weight(results3.getInt("suggested_weight"));
                    exercise.setNum_of_reps(results3.getInt("num_of_reps"));
                    exercise.setDuration(results3.getInt("duration"));
                    exercise.setTarget_area(results3.getString("target_area"));
                    exercises.add(exercise);
                }
            }
            workouts.get(i).setExercises(exercises);
        }
        return workouts;
    }

    @Override
    public Workout getWorkoutByName(String workoutName) {
        Workout workout = new Workout();
        workout.setWorkout_name(workoutName);
        ArrayList<Exercise> exercises = new ArrayList<>();
        String sql = "SELECT * FROM workout_exercise WHERE workout_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, workoutName);
        while (results.next()) {
            String sql2 = "SELECT * FROM exercise WHERE exercise_id = ?";
            SqlRowSet results2 = jdbcTemplate.queryForRowSet(sql2, results.getInt("exercise"));
            if (results2.next()) {
                Exercise exercise = new Exercise();
                exercise.setExercise_id(results2.getInt("exercise_id"));
                exercise.setExercise_name(results2.getString("exercise_name"));
                exercise.setExercise_description(results2.getString("exercise_description"));
                exercise.setSuggested_weight(results2.getInt("suggested_weight"));
                exercise.setNum_of_reps(results2.getInt("num_of_reps"));
                exercise.setDuration(results2.getInt("duration"));
                exercise.setTarget_area(results2.getString("target_area"));
                exercises.add(exercise);
            }
        }
        workout.setExercises(exercises);
        return workout;
    }

    @Override
    public boolean addExerciseToWorkout(Workout workout, int exercise_id) {
        ArrayList<Exercise> exercises = workout.getExercises();
        String sql = "insert into workout_exercise(workout_name, user_id, exercise) VALUES (?,?,?) RETURNING workout_exercise_id";
        try{
            jdbcTemplate.queryForObject(sql, Integer.class, workout.getWorkout_name(), 1, exercise_id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public boolean createWorkoutExercise(WorkoutExercise workoutExercise) {
        String sql = "insert into workout_exercise(workout_name, user_id, exercise) VALUES (?,?,?) RETURNING workout_exercise_id";
        Integer newId;
        try{
            newId = jdbcTemplate.queryForObject(sql,
                    Integer.class, workoutExercise.getWorkout_name(), workoutExercise.getUser_id(), workoutExercise.getExercise());
            workoutExercise.setWorkout_exercise_id(newId);
        }catch (DataAccessException e){
            return false;
        }
        return true;
    }

    @Override
    public WorkoutExercise updateWorkoutExercise(WorkoutExercise workoutExercise, int id) {
        try {
            String sql = "UPDATE workout_exercise SET workout_name = ? WHERE workout_exercise_id = ?";
            jdbcTemplate.update(sql, workoutExercise.getWorkout_name(), id);
            sql = "UPDATE workout_exercise SET user_id = ? WHERE workout_exercise_id = ?";
            jdbcTemplate.update(sql, workoutExercise.getUser_id(), id);
            sql = "UPDATE workout_exercise SET exercise = ? WHERE workout_exercise_id = ?";
            jdbcTemplate.update(sql, workoutExercise.getExercise(), id);
        } catch (DataAccessException e){
            System.out.println("Failed to update workout " + id + "!");
        }
        return workoutExercise;
    }

    @Override
    public void deleteWorkoutExercise(int id) {
        String sql = "DELETE FROM workout_exercise WHERE workout_exercise_id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException e){
            System.out.println("Failed to delete workout " + id + "!");
        }
    }

    private WorkoutExercise mapRowToWorkout(SqlRowSet rs) {
        WorkoutExercise workout = new WorkoutExercise();
        workout.setWorkout_exercise_id(rs.getInt("workout_exercise_id"));
        workout.setWorkout_name(rs.getString("workout_name"));
        workout.setUser_id(rs.getInt("user_Id"));
        workout.setExercise(rs.getInt("exercise"));
        return workout;
    }
}
