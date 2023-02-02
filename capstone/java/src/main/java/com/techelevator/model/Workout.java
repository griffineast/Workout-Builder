package com.techelevator.model;

import java.util.ArrayList;

public class Workout {
    private int workout_id;
    private String workout_name;
    private int user_id;
    private int exercise;

    public Workout() {

    }

    public Workout(int workout_id, String workout_name, int user_id, int exercise) {
        this.workout_id = workout_id;
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

    public int getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(int workout_id) {
        this.workout_id = workout_id;
    }

    public int getExercise() {
        return exercise;
    }

    public void setExercise(int exercise) {
        this.exercise = exercise;
    }
}
