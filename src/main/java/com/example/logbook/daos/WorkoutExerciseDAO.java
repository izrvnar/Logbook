package com.example.logbook.daos;

import com.example.logbook.pojo.Exercise;
import com.example.logbook.pojo.Workout;

public interface WorkoutExerciseDAO {
    void addExerciseToWorkout(Workout workout, Exercise exercise);

    //display all exercises in a workout
    void displayExercisesInWorkout(Workout workout);
}
