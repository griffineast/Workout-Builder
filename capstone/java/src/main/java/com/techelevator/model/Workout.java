package com.techelevator.model;

import java.util.ArrayList;

public class Workout {
    private int workout_id;
    private int user_id;
    private String workout_date;
    private int arms_duration;
    private int back_duration;
    private int legs_duration;
    private int ab_duration;

    public Workout() {}

    public Workout(int workout_id, int user_id, String workout_date, int arms_duration, int legs_duration, int back_duration,  int ab_duration) {
        this.workout_id = workout_id;
        this.user_id = user_id;
        this.workout_date = workout_date;
        this.arms_duration = arms_duration;
        this.legs_duration = legs_duration;
        this.back_duration = back_duration;
        this.ab_duration = ab_duration;
    }

    public int getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(int workout_id) {
        this.workout_id = workout_id;
    }

    public String getWorkout_date() {
        return workout_date;
    }

    public void setWorkout_date(String workout_date) {
        this.workout_date = workout_date;
    }

    public int getAb_duration() {
        return ab_duration;
    }

    public void setAb_duration(int ab_duration) {
        this.ab_duration = ab_duration;
    }

    public int getArms_duration() {
        return arms_duration;
    }

    public void setArms_duration(int arms_duration) {
        this.arms_duration = arms_duration;
    }

    public int getBack_duration() {
        return back_duration;
    }

    public void setBack_duration(int back_duration) {
        this.back_duration = back_duration;
    }

    public int getLegs_duration() {
        return legs_duration;
    }

    public void setLegs_duration(int legs_duration) {
        this.legs_duration = legs_duration;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
