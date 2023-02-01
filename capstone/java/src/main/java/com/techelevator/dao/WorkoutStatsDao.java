package com.techelevator.dao;

import com.techelevator.model.WorkoutStats;

import java.util.List;

public interface WorkoutStatsDao {

    List<WorkoutStats> allWorkoutStats();

    WorkoutStats getWorkoutStatsById(int workoutId);

    boolean createWorkoutStat(WorkoutStats workout);

}
