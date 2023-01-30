package com.techelevator.dao;

import com.techelevator.model.Exercise;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcExerciseDao implements ExerciseDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcExerciseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Exercise> allExercises() {
        List<Exercise> exercises = new ArrayList<>();
        String sql = "SELECT * FROM exercise";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Exercise exercise = mapRowToExercise(results);
            exercises.add(exercise);
        }

        return exercises;
    }

    @Override
    public Exercise getExerciseById(int exerciseId) {
        String sql = "SELECT * FROM exercise WHERE exercise_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, exerciseId);
        if (results.next()) {
            return mapRowToExercise(results);
        } else {
            return null;
        }
    }

    @Override
    public boolean createExercise(String exercise_name, String exercise_description, int suggested_weight, int num_of_reps, int duration, String target_area) {
        String insertExerciseSql = "insert into exercise (exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area) values (?,?,?,?,?,?)";
//        String password_hash = new BCryptPasswordEncoder().encode(password);
//        String ssRole = role.toUpperCase().startsWith("ROLE_") ? role.toUpperCase() : "ROLE_" + role.toUpperCase();

        return jdbcTemplate.update(insertExerciseSql, exercise_name, exercise_description, suggested_weight, num_of_reps, duration, target_area) == 1;
    }











    private Exercise mapRowToExercise(SqlRowSet rs) {
        Exercise exercise = new Exercise();
        exercise.setExercise_id(rs.getInt("exercise_id"));
        exercise.setExercise_name(rs.getString("exercise_name"));
        exercise.setExercise_description(rs.getString("exercise_description"));
        exercise.setSuggested_weight(rs.getInt("suggested_weight"));
        exercise.setNum_of_reps(rs.getInt("num_of_reps"));
        exercise.setDuration(rs.getInt("duration"));
        exercise.setTarget_area(rs.getString("target_area"));

        return exercise;
    }


}
