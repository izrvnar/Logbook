package com.example.logbook.tables;

import com.example.logbook.daos.BodyWeightDAO;
import com.example.logbook.database.DBConst;
import com.example.logbook.database.Database;
import com.example.logbook.pojo.BodyWeight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BodyWeightTable implements BodyWeightDAO {

    // creating connection to the database
    private static BodyWeightTable instance;
    Database db = Database.getInstance();
    ArrayList<BodyWeight> bodyWeights;


    @Override
    public void createBodyWeight(BodyWeight bodyWeight) {
        String query = "INSERT INTO " + DBConst.TABLE_BODY_WEIGHT +
                "(" + DBConst.BODY_WEIGHT_COLUMN_WEIGHT + ", " +
                DBConst.BODY_WEIGHT_COLUMN_DATE + ") VALUES ('" +
                bodyWeight.getWeight() + "','" + bodyWeight.getDate_weight() +"')";

        try{
            db.getConnection().createStatement().execute(query);
            System.out.println("Body weight added");

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<BodyWeight> getAllWeights() {
        String query = "SELECT * FROM " + DBConst.TABLE_BODY_WEIGHT;
        bodyWeights = new ArrayList<>();

        // try statement
        try{
            Statement getBodyWeight = db.getConnection().createStatement();
            ResultSet data = getBodyWeight.executeQuery(query);

            while(data.next()){
                bodyWeights.add(
                        new BodyWeight(data.getInt(DBConst.BODY_WEIGHT_COLUMN_ID),
                                data.getFloat(DBConst.BODY_WEIGHT_COLUMN_WEIGHT),
                                data.getTimestamp(DBConst.BODY_WEIGHT_COLUMN_DATE)
                                ));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return bodyWeights;
    }

    @Override
    public void deleteBodyWeight(int id) {

    }

    // singleton
    public static  BodyWeightTable getInstance(){
        if (instance == null){
            instance = new BodyWeightTable();
        }
        return instance;
    }
}
