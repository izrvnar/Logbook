package com.example.logbook.pojo;

public class Exercise {
    private int exercise_id;
    private String name;
    private int sets;
    private int reps;
    private float weight;
    private int category_id;

    public Exercise(int exercise_id, String name, int sets, int reps, float weight, int category_id) {
        this.exercise_id = exercise_id;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.category_id = category_id;
    }

    public int getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(int exercise_id) {
        this.exercise_id = exercise_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
