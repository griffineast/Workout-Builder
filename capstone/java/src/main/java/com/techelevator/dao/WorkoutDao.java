package com.techelevator.dao;

import com.techelevator.model.Workout;

import java.util.List;

public interface WorkoutDao {

    List<Workout> allWorkouts();

    Workout getWorkoutById(int workoutId);

    boolean createWorkout(Workout workout);

}
