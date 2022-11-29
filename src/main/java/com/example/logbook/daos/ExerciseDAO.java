package com.example.logbook.daos;

import com.example.logbook.pojo.Exercise;

import java.util.ArrayList;

public interface ExerciseDAO {
    // create a exercise
    void createExercise(Exercise exercise);

    // get all exercises
    ArrayList<Exercise> getAllExercises();

    //get single exercise
    Exercise getExercise(int id);

    // update exercise
    void updateExercise(int id);

    //delete exercise
    void deleteExercise(int id);


}
