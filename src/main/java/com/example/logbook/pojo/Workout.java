package com.example.logbook.pojo;

import java.util.Date;

public class Workout {
    private int workout_id;
    private String name;
    private Date workout_date;

    public Workout(int workout_id, String name, Date workout_date) {
        this.workout_id = workout_id;
        this.name = name;
        this.workout_date = workout_date;
    }

    // constructor without ID


    public Workout(String name, Date workout_date) {
        this.name = name;
        this.workout_date = workout_date;
    }

    public int getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(int workout_id) {
        this.workout_id = workout_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getWorkout_date() {
        return workout_date;
    }

    public void setWorkout_date(Date workout_date) {
        this.workout_date = workout_date;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
