package com.techelevator.dao;

import com.techelevator.model.Workout;
import com.techelevator.model.WorkoutExercise;

import java.util.ArrayList;
import java.util.List;

public interface WorkoutExerciseDao {
    ArrayList<Workout> allWorkouts();

    WorkoutExercise getWorkoutExerciseById(int workout_exercise_id);

    boolean createWorkoutExercise(WorkoutExercise workoutExercise);

    WorkoutExercise updateWorkoutExercise(WorkoutExercise workoutExercise, int id);

    void deleteWorkoutExercise(int id);

    //ArrayList<Integer> getWorkoutExercises(String name);
}
