package com.example.logbook.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class DisplayWorkout {
    private int workout_id;
    private String name;
    private Date workout_date;

    public DisplayWorkout(int workout_id, String name, Date workout_date) {
        this.workout_id = workout_id;
        this.name = name;
        this.workout_date = workout_date;
    }

    public DisplayWorkout(String name, Date workout_date) {
        this.name = name;
        this.workout_date = workout_date;
    }

    public DisplayWorkout(String name) {
        this.name = name;
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


}
