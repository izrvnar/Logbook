package com.example.logbook.tables;

import com.example.logbook.daos.ExerciseDAO;
import com.example.logbook.database.DBConst;
import com.example.logbook.database.Database;
import com.example.logbook.pojo.DisplayExercise;
import com.example.logbook.pojo.Exercise;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ExerciseTable implements ExerciseDAO {

    // getting db instance
    Database db = Database.getInstance();

    ArrayList<Exercise> exercises;


    @Override
    public void createExercise(Exercise exercise) {
        String query = "INSERT INTO " + DBConst.TABLE_EXERCISE +
                " (" + DBConst.EXERCISE_COLUMN_NAME + ", " +
                DBConst.EXERCISE_COLUMN_SETS + ", " +
                DBConst.EXERCISE_COLUMN_REPS + ", " +
                DBConst.EXERCISE_COLUMN_WEIGHT + ", " +
                DBConst.EXERCISE_COLUMN_CATEGORY_ID + ") " +
                "VALUES ('" + exercise.getName() + "', '" +
                exercise.getSets() + "', '" +
                exercise.getReps() + "', '" +
                exercise.getWeight() + "', '" +
                exercise.getCategory_id() + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Exercise Added");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Exercise> getAllExercises() {
       String query = "SELECT * FROM " + DBConst.TABLE_EXERCISE;
       exercises = new ArrayList<>();
       try {
           Statement getExercises = db.getConnection().createStatement();
           ResultSet data = getExercises.executeQuery(query);
           while (data.next()) {
               exercises.add(new Exercise(
                       data.getInt(DBConst.EXERCISE_COLUMN_ID),
                       data.getString(DBConst.EXERCISE_COLUMN_NAME),
                       data.getInt(DBConst.EXERCISE_COLUMN_SETS),
                       data.getInt(DBConst.EXERCISE_COLUMN_REPS),
                       data.getInt(DBConst.EXERCISE_COLUMN_WEIGHT),
                       data.getInt(DBConst.EXERCISE_COLUMN_CATEGORY_ID)));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
         return exercises;
    }


    // get a single exercise
        @Override
    public Exercise getExercise(int id) {
            String query = "SELECT * FROM " + DBConst.TABLE_EXERCISE +
                    " WHERE " + DBConst.EXERCISE_COLUMN_ID + " = " + id;
            try{
                Statement getCoin = db.getConnection().createStatement();
                ResultSet data = getCoin.executeQuery(query);
                if(data.next()){
                    Exercise exercise = new Exercise(
                            data.getInt(DBConst.EXERCISE_COLUMN_ID),
                            data.getString(DBConst.EXERCISE_COLUMN_NAME),
                            data.getInt(DBConst.EXERCISE_COLUMN_SETS),
                            data.getInt(DBConst.EXERCISE_COLUMN_REPS),
                            data.getInt(DBConst.EXERCISE_COLUMN_WEIGHT),
                            data.getInt(DBConst.EXERCISE_COLUMN_CATEGORY_ID));
                    return exercise;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

    @Override
    public void updateExercise(Exercise exercise) {
        String query = "UPDATE " + DBConst.TABLE_EXERCISE +
                " SET " + DBConst.EXERCISE_COLUMN_NAME + " = '" + exercise.getName() + "', " +
                DBConst.EXERCISE_COLUMN_SETS + " = '" + exercise.getSets() + "', " +
                DBConst.EXERCISE_COLUMN_REPS + " = '" + exercise.getReps() + "', " +
                DBConst.EXERCISE_COLUMN_WEIGHT + " = '" + exercise.getWeight() + "', " +
                DBConst.EXERCISE_COLUMN_CATEGORY_ID + " = '" + exercise.getCategory_id() + "' " +
                " WHERE " + DBConst.EXERCISE_COLUMN_ID + " = " + exercise.getExercise_id();

        try {
            Statement updateExercise = db.getConnection().createStatement();
            updateExercise.executeUpdate(query);
            System.out.println("Exercise Updated");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteExercise(int id) {
        String query = "DELETE FROM " + DBConst.TABLE_EXERCISE +
                " WHERE " + DBConst.EXERCISE_COLUMN_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Exercise Deleted");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public int getCategoryCount(int category){
        int count = -1;
        try{
            PreparedStatement getCount = db.getConnection().prepareStatement("SELECT * FROM " + DBConst.TABLE_EXERCISE + " WHERE "+ DBConst.EXERCISE_COLUMN_CATEGORY_ID + " = " + category +"", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet data = getCount.executeQuery();
            data.last();
            count =  data.getRow();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public ArrayList<DisplayExercise> getDisplayExericeItems(){
        ArrayList<DisplayExercise> displayExerciseArrayList = new ArrayList<>();
        String query = """
                        SELECT exercise.exercise_id, 
                        exercise.name, 
                        exercise.sets, 
                        exercise.reps, 
                        exercise.weight,
                        exercise.category_id, 
                        categories.name AS cat_name
                        FROM exercise JOIN categories ON categories.category_id = exercise.category_id;
                    """;

        try {
            Statement getExercises = db.getConnection().createStatement();
            ResultSet data = getExercises.executeQuery(query);
            while (data.next()) {
                displayExerciseArrayList.add(new DisplayExercise(
                        data.getInt("exercise_id"),
                        data.getString("name"),
                        data.getInt("sets"),
                        data.getInt("reps"),
                        data.getInt("weight"),
                        data.getString("cat_name"),
                        data.getInt("category_id")
                        ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return displayExerciseArrayList;
    }



}
