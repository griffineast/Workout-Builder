package com.techelevator.dao;

import com.techelevator.model.Exercise;

import java.util.List;

public interface ExerciseDao {

    List<Exercise> allExercises();

    Exercise getExerciseById(int exerciseId);

    boolean createExercise(Exercise exercise);

//    Exercise editExercise(int exerciseId, String exercise_name, String exercise_description, int suggested_weight, int num_of_reps, int duration, String target_area);

}
