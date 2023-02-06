package com.techelevator.dao;

import com.techelevator.model.WorkoutExercise;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWorkoutExerciseDao implements WorkoutExerciseDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcWorkoutExerciseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ArrayList<Integer> getWorkoutExercises(String workout_name) {
        ArrayList<Integer> exercises = new ArrayList<>();
        String sql = "SELECT exercise FROM workout_exercise WHERE workout_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, workout_name);
        while (results.next()) {
            exercises.add(results.getInt("exercise"));
        }
        return exercises;
    }

    @Override
    public List<WorkoutExercise> allWorkoutExercises() {
        List<WorkoutExercise> workoutExercises = new ArrayList<>();
        String sql = "SELECT * FROM workout_exercise";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            WorkoutExercise workoutExercise = mapRowToWorkout(results);
            workoutExercises.add(workoutExercise);
        }
        return workoutExercises;
    }

    @Override
    public WorkoutExercise getWorkoutExerciseById(int workout_exercise_id) {
        String sql = "SELECT * FROM workout_exercise WHERE workout_exercise_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, workout_exercise_id);
        if (results.next()) {
            return mapRowToWorkout(results);
        } else {
            return null;
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
        String sql = "DELETE FROM workout_exercise WHERE workout_id = ?";
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
