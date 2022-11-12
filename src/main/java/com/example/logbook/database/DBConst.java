package com.example.logbook.database;

public class DBConst {

    //many-to-many table workout_exercise
    public static final String TABLE_WORKOUT_EXERCISE = "workout_exercise";
    public static final String WORKOUT_EXERCISE_COLUMN_WORKOUT_ID = "workout_id";
    public static final String WORKOUT_EXERCISE_COLUMN_EXERCISE_ID = "exercise_id";

    // workout table
    public static final String TABLE_WORKOUT = "workout";
    public static final String WORKOUT_COLUMN_ID = "workout_id";
    public static final String WORKOUT_COLUMN_NAME = "name";
    public static final String WORKOUT_COLUMN_WORKOUT_DATE = "workout_date";

    //exercise table
    public static final String TABLE_EXERCISE = "exercise";
    public static final String EXERCISE_COLUMN_ID = "exercise_id";
    public static final String EXERCISE_COLUMN_NAME = "name";
    public static final String EXERCISE_COLUMN_SETS = "sets";
    public static final String EXERCISE_COLUMN_REPS = "reps";
    public static final String EXERCISE_COLUMN_WEIGHT = "weight";
    public static final String EXERCISE_COLUMN_CATEGORY_ID = "category_id";

    //category table
    public static final String TABLE_CATEGORY = "category_id";
    public static final String CATEGORY_COLUMN_NAME = "name";

    // body weight table
    public static final String TABLE_BODY_WEIGHT = "body_weight";
    public static final String BODY_WEIGHT_COLUMN_DATE = "date";
    public static final String BODY_WEIGHT_COLUMN_WEIGHT = "weight";













}
