package com.techelevator.dao;

import com.techelevator.model.WorkoutStats;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWorkoutStatsDao implements WorkoutStatsDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcWorkoutStatsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<WorkoutStats> allWorkoutStats() {
        List<WorkoutStats> workoutStats = new ArrayList<>();
        String sql = "SELECT * FROM workout_stats";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            WorkoutStats workoutStat = mapRowToWorkoutStat(results);
            workoutStats.add(workoutStat);
        }
        return workoutStats;
    }

    @Override
    public WorkoutStats getWorkoutStatsById(int workoutId) {
        String sql = "SELECT * FROM workout_stats WHERE workout_stats_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, workoutId);
        if (results.next()) {
            return mapRowToWorkoutStat(results);
        } else {
            return null;
        }
    }

    @Override
    public boolean createWorkoutStat(WorkoutStats workoutStats) {
        String sql = "insert into workout_stats(user_id, workout_date, biceps_duration, triceps_duration, chest_duration, shoulders_duration, back_duration, legs_duration, abs_duration, cardio_duration) VALUES (?,?,?,?,?,?,?,?,?,?) RETURNING workout_stats_id";
        Integer newId;
        try{
            newId = jdbcTemplate.queryForObject(sql,
                    Integer.class, workoutStats.getUser_id(), workoutStats.getWorkout_date(), workoutStats.getBiceps_duration(), workoutStats.getTriceps_duration(), workoutStats.getChest_duration(), workoutStats.getShoulders_duration(), workoutStats.getBack_duration(), workoutStats.getLegs_duration(), workoutStats.getAbs_duration(), workoutStats.getCardio_duration());
            workoutStats.setWorkout_stats_id(newId);
       }catch (DataAccessException e){
           return false;
        }
        return true;
//        String password_hash = new BCryptPasswordEncoder().encode(password);
//        String ssRole = role.toUpperCase().startsWith("ROLE_") ? role.toUpperCase() : "ROLE_" + role.toUpperCase();
    }


    private WorkoutStats mapRowToWorkoutStat(SqlRowSet rs) {
        WorkoutStats workoutStat = new WorkoutStats();
        workoutStat.setWorkout_stats_id(rs.getInt("workout_stats_id"));
        workoutStat.setUser_id(rs.getInt("user_id"));
        workoutStat.setWorkout_date(rs.getString("workout_date"));
        workoutStat.setBiceps_duration(rs.getInt("biceps_duration"));
        workoutStat.setTriceps_duration(rs.getInt("triceps_duration"));
        workoutStat.setChest_duration(rs.getInt("chest_duration"));
        workoutStat.setShoulders_duration(rs.getInt("shoulders_duration"));
        workoutStat.setBack_duration(rs.getInt("back_duration"));
        workoutStat.setLegs_duration(rs.getInt("legs_duration"));
        workoutStat.setAbs_duration(rs.getInt("abs_duration"));
        workoutStat.setCardio_duration(rs.getInt("cardio_duration"));

        return workoutStat;
    }

}
