package com.example.logbook.daos;

import com.example.logbook.pojo.DisplayExercise;
import com.example.logbook.pojo.DisplayWorkout;
import com.example.logbook.pojo.Exercise;
import com.example.logbook.pojo.Workout;

public interface WorkoutExerciseDAO {
    void addExerciseToWorkout(DisplayWorkout workout, DisplayExercise exercise);

    //display all exercises in a workout
    void displayExercisesInWorkout(Workout workout);
}
