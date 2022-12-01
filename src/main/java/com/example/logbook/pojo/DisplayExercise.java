package com.example.logbook.pojo;

public class DisplayExercise {
    private int exercise_id;
    private String name;
    private int sets;
    private int reps;
    private float weight;
    private String category_name;

    // add id
    private int category_id;

    public DisplayExercise(int exercise_id, String name, int sets, int reps, float weight, String category_name, int category_id) {
        this.exercise_id = exercise_id;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.category_name = category_name;
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

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
