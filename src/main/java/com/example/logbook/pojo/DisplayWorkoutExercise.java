package com.example.logbook.pojo;

public class DisplayWorkoutExercise {
    private int workoutId;
    private int exerciseId;

    public DisplayWorkoutExercise(int workoutId, int exerciseId) {
        this.workoutId = workoutId;
        this.exerciseId = exerciseId;
    }

    public int getWorkoutId(){
        return workoutId;
    }

    public void setWorkoutId(int workoutId){
        this.workoutId = workoutId;
    }

    public int getExerciseId(){
        return exerciseId;
    }

    public void setExerciseId(int exerciseId){
        this.exerciseId = exerciseId;
    }

}
