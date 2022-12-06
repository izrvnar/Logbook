package com.example.logbook.tables;

import com.example.logbook.daos.WorkoutExerciseDAO;
import com.example.logbook.database.DBConst;
import com.example.logbook.database.Database;
import com.example.logbook.pojo.Exercise;
import com.example.logbook.pojo.Workout;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DisplayWorkoutExerciseTable implements WorkoutExerciseDAO {

    Database db = Database.getInstance();

    ArrayList<Exercise> exercises;

    @Override
    public void addExerciseToWorkout(Workout workout, Exercise exercise) {
        String query = "INSERT INTO " + DBConst.TABLE_WORKOUT_EXERCISE +
                " (" + DBConst.WORKOUT_EXERCISE_COLUMN_WORKOUT_ID + ", " +
                DBConst.WORKOUT_EXERCISE_COLUMN_EXERCISE_ID + ") " +
                "VALUES ('" + workout.getWorkout_id() + "', '" +
                exercise.getExercise_id() + "')";
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Exercise Added");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void displayExercisesInWorkout(Workout workout) {
        String query = "SELECT * FROM " + DBConst.TABLE_EXERCISE + " INNER JOIN " + DBConst.TABLE_WORKOUT_EXERCISE + " ON " + DBConst.TABLE_EXERCISE +
                "." + DBConst.EXERCISE_COLUMN_ID + " = " + DBConst.TABLE_WORKOUT_EXERCISE + "." + DBConst.WORKOUT_EXERCISE_COLUMN_EXERCISE_ID +
                " WHERE " + DBConst.TABLE_WORKOUT_EXERCISE + "." + DBConst.WORKOUT_EXERCISE_COLUMN_WORKOUT_ID + " = " + workout.getWorkout_id();

        try{
            exercises = new ArrayList<>();
            Statement getExercises = db.getConnection().createStatement();
            ResultSet data = getExercises.executeQuery(query);
            while(data.next()){
                exercises.add(new Exercise(
                        data.getInt(DBConst.EXERCISE_COLUMN_ID),
                        data.getString(DBConst.EXERCISE_COLUMN_NAME),
                        data.getInt(DBConst.EXERCISE_COLUMN_SETS),
                        data.getInt(DBConst.EXERCISE_COLUMN_REPS),
                        data.getInt(DBConst.EXERCISE_COLUMN_WEIGHT),
                        data.getInt(DBConst.EXERCISE_COLUMN_CATEGORY_ID)
                ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}

