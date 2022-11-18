package com.example.logbook.pojo;

import java.sql.Timestamp;

public class BodyWeight {
    private int id;
    private float weight;
    private Timestamp date_weight;

    public BodyWeight(int id, float weight, Timestamp date_weight) {
        this.id = id;
        this.weight = weight;
        this.date_weight = date_weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Timestamp getDate_weight() {
        return date_weight;
    }

    public void setDate_weight(Timestamp date_weight) {
        this.date_weight = date_weight;
    }

}
