package com.example.logbook.daos;

import com.example.logbook.pojo.BodyWeight;

import java.util.ArrayList;

public interface BodyWeightDAO {
    //create body weight entry
    void createBodyWeight(BodyWeight bodyWeight);

    // get all body weights
    ArrayList<BodyWeight> getAllWeights();

    // delete bod weight
    void deleteBodyWeight(int id);
}
