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
public class JdbcWorkoutDao implements WorkoutDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcWorkoutDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
    public Workout getWorkoutById(int workoutId) {
        String sql = "SELECT * FROM workout WHERE workout_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, workoutId);
        if (results.next()) {
            return mapRowToWorkout(results);
        } else {
            return null;
        }
    }

    @Override
    public boolean createWorkout(Workout workout) {
        String sql = "insert into workout(user_id, workout_date, arms_duration, legs_duration, back_duration, ab_duration) VALUES (?,?,?,?,?,?) RETURNING workout_id";
        Integer newId;
        try{
            newId = jdbcTemplate.queryForObject(sql,
                    Integer.class, workout.getUser_id(), workout.getWorkout_date(), workout.getArms_duration(), workout.getLegs_duration(), workout.getBack_duration(), workout.getAb_duration());
            workout.setWorkout_id(newId);
       }catch (DataAccessException e){
           return false;
        }
        return true;
//        String password_hash = new BCryptPasswordEncoder().encode(password);
//        String ssRole = role.toUpperCase().startsWith("ROLE_") ? role.toUpperCase() : "ROLE_" + role.toUpperCase();
    }


    private Workout mapRowToWorkout(SqlRowSet rs) {
        Workout workout = new Workout();
        workout.setWorkout_id(rs.getInt("workout_id"));
        workout.setUser_id(rs.getInt("user_id"));
        workout.setWorkout_date(rs.getString("workout_date"));
        workout.setArms_duration(rs.getInt("arms_duration"));
        workout.setLegs_duration(rs.getInt("legs_duration"));
        workout.setBack_duration(rs.getInt("back_duration"));
        workout.setAb_duration(rs.getInt("ab_duration"));

        return workout;
    }

}
