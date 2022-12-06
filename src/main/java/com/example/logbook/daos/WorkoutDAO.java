package com.example.logbook.daos;

import com.example.logbook.pojo.Workout;

import java.util.ArrayList;

public interface WorkoutDAO {
    // gets all workouts
    ArrayList<Workout> getAllWorkouts();

    //gets a single workout
    Workout getWorkout(int id);

    // creates a workout
    void createWorkout(Workout workout);

    // delete a workout
    void deleteWorkout(int id);

    //update a workout
    void updateWorkout(int id);

}
