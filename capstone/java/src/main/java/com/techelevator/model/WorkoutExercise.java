package com.techelevator.model;

public class WorkoutExercise {
    private int workout_exercise_id;
    private String workout_name;
    private int user_id;
    private int exercise;

    public WorkoutExercise() {

    }

    public WorkoutExercise(int workout_exercise_id, String workout_name, int user_id, int exercise) {
        this.workout_exercise_id = workout_exercise_id;
        this.workout_name = workout_name;
        this.user_id = user_id;
        this.exercise = exercise;
    }

    public String getWorkout_name() {
        return workout_name;
    }

    public void setWorkout_name(String workout_name) {
        this.workout_name = workout_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getWorkout_exercise_id() {
        return workout_exercise_id;
    }

    public void setWorkout_exercise_id(int workout_id) {
        this.workout_exercise_id = workout_id;
    }

    public int getExercise() {
        return exercise;
    }

    public void setExercise(int exercise) {
        this.exercise = exercise;
    }
}
