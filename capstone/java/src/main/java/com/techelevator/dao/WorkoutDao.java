package com.techelevator.dao;

import com.techelevator.model.Exercise;
import com.techelevator.model.Workout;

import java.util.ArrayList;
import java.util.List;

public interface WorkoutDao {
    List<Workout> allWorkouts();

    Workout getWorkoutById(int workout_id);

    boolean createWorkout(Workout workout);

    Workout updateWorkout(Workout workout, int id);

    void deleteWorkout(int id);

    ArrayList<Integer> getCompleteWorkout(String name);
}
