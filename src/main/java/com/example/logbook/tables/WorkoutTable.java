package com.example.logbook.tables;

import com.example.logbook.daos.WorkoutDAO;
import com.example.logbook.database.DBConst;
import com.example.logbook.database.Database;
import com.example.logbook.pojo.Workout;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class WorkoutTable implements WorkoutDAO {
    // creating connection to the database
    Database db = Database.getInstance();

    ArrayList<Workout> workouts;
    @Override
    public ArrayList<Workout> getAllWorkouts() {
        String query = "SELECT * FROM " + DBConst.TABLE_WORKOUT;
        workouts = new ArrayList<>();
        try{
            Statement getWorkouts = db.getConnection().createStatement();
            ResultSet data = getWorkouts.executeQuery(query);
            while(data.next()){
                workouts.add(new Workout(
                        data.getInt(DBConst.WORKOUT_COLUMN_ID),
                        data.getString(DBConst.WORKOUT_COLUMN_NAME),
                        data.getTimestamp(DBConst.WORKOUT_COLUMN_WORKOUT_DATE)
                ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return workouts;
    }

    @Override
    public Workout getWorkout(int id) {
        return null;
    }

    @Override
    public void createWorkout(Workout workout) {
        String query = "INSERT INTO " + DBConst.TABLE_WORKOUT + " (" + DBConst.WORKOUT_COLUMN_NAME + ", " + DBConst.WORKOUT_COLUMN_WORKOUT_DATE + ") VALUES ('" + workout.getName() + "','" + workout.getWorkout_date() + "')";
        try{
            db.getConnection().createStatement().execute(query);
            System.out.println("Workout added");
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteWorkout(int id) {

    }

    @Override
    public void updateWorkout(int id) {

    }
}
