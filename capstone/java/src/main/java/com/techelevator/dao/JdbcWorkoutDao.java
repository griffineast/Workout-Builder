package com.techelevator.dao;

import com.techelevator.model.Exercise;
import com.techelevator.model.Workout;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWorkoutDao implements WorkoutDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcWorkoutDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ArrayList<Integer> getCompleteWorkout(String workout_name) {
        ArrayList<Integer> exercises = new ArrayList<>();
        String sql = "SELECT exercise FROM workout WHERE workout_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, workout_name);

        return exercises;
    }

    @Override
    public List<Workout> allWorkouts() {
        List<Workout> workouts = new ArrayList<>();
        String sql = "SELECT * FROM workout";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Workout workout = mapRowToWorkout(results);
            workouts.add(workout);
        }
        return workouts;
    }

    @Override
    public Workout getWorkoutById(int workout_id) {
        String sql = "SELECT * FROM workout WHERE workout_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, workout_id);
        if (results.next()) {
            return mapRowToWorkout(results);
        } else {
            return null;
        }
    }

    @Override
    public boolean createWorkout(Workout workout) {
        String sql = "insert into workout(workout_name, user_id, exercise) VALUES (?,?,?,) RETURNING workout_id";
        Integer newId;
        try{
            newId = jdbcTemplate.queryForObject(sql,
                    Integer.class, workout.getWorkout_name(), workout.getUser_id(), workout.getExercise());
            workout.setWorkout_id(newId);
        }catch (DataAccessException e){
            return false;
        }
        return true;
    }

    @Override
    public Workout updateWorkout(Workout workout, int id) {
        try {
            String sql = "UPDATE workout SET workout_name = ? WHERE workout_id = ?";
            jdbcTemplate.update(sql, workout.getWorkout_name(), id);
            sql = "UPDATE exercise SET user_id = ? WHERE workout_id = ?";
            jdbcTemplate.update(sql, workout.getUser_id(), id);
            sql = "UPDATE exercise SET exercise = ? WHERE workout_id = ?";
            jdbcTemplate.update(sql, workout.getExercise(), id);
        } catch (DataAccessException e){
            System.out.println("Failed to update workout " + id + "!");
        }
        return workout;
    }

    @Override
    public void deleteWorkout(int id) {
        String sql = "DELETE FROM workout WHERE workout_id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException e){
            System.out.println("Failed to delete workout " + id + "!");
        }
    }

    private Workout mapRowToWorkout(SqlRowSet rs) {
        Workout workout = new Workout();
        workout.setWorkout_id(rs.getInt("workout_id"));
        workout.setWorkout_name(rs.getString("workout_name"));
        workout.setUser_id(rs.getInt("user_Id"));
        workout.setExercise(rs.getInt("exercise"));
        return workout;
    }
}
