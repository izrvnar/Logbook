package com.example.logbook.database;

public class DBConst {

    //many-to-many table workout_exercise
    public static final String TABLE_WORKOUT_EXERCISE = "workout_exercise";
    public static final String WORKOUT_EXERCISE_COLUMN_ID = "id";
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
    public static final String TABLE_CATEGORY = "categories";
    public static final String CATEGORY_COLUMN_ID = "category_id";
    public static final String CATEGORY_COLUMN_NAME = "name";

    // body weight table
    public static final String TABLE_BODY_WEIGHT = "body_weight";
    public static final String BODY_WEIGHT_COLUMN_ID = "id";
    public static final String BODY_WEIGHT_COLUMN_DATE = "date_weight";
    public static final String BODY_WEIGHT_COLUMN_WEIGHT = "weight";

    // table create statements

    //Workout Table
    public static final String CREATE_TABLE_WORKOUT =
            "CREATE TABLE " + TABLE_WORKOUT + " (" +
                    WORKOUT_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    WORKOUT_COLUMN_NAME + " VARCHAR(50), " +
                    WORKOUT_COLUMN_WORKOUT_DATE + " datetime, " +
                    "PRIMARY KEY(" + WORKOUT_COLUMN_ID +")" +
                    ");";

    // Exercise Table
    public static final String CREATE_TABLE_EXERCISE =
            "CREATE TABLE " + TABLE_EXERCISE + " (" +
                    EXERCISE_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    EXERCISE_COLUMN_NAME + " VARCHAR(50), " +
                    EXERCISE_COLUMN_SETS + " int(3), " +
                    EXERCISE_COLUMN_REPS + " int(3), " +
                    EXERCISE_COLUMN_WEIGHT + " float, " +
                    EXERCISE_COLUMN_CATEGORY_ID + " int(11), " +
                    "FOREIGN KEY (" + EXERCISE_COLUMN_CATEGORY_ID +")" +
                    " REFERENCES " + TABLE_CATEGORY +"(" +CATEGORY_COLUMN_ID +")," +
                    "PRIMARY KEY(" + EXERCISE_COLUMN_ID +")" +

                    ");";

    //Body Weight Table
    public static final String CREATE_TABLE_BODY_WEIGHT =
            "CREATE TABLE " + TABLE_BODY_WEIGHT + " (" +
                    BODY_WEIGHT_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    BODY_WEIGHT_COLUMN_DATE + " DATETIME NOT NULL " +
                    BODY_WEIGHT_COLUMN_WEIGHT + " FLOAT NOT NULL, " +
                    "PRIMARY KEY(" + BODY_WEIGHT_COLUMN_ID +")" +
                    ");";

    // Category Table
    public static final String CREATE_TABLE_CATEGORY =
            "CREATE TABLE " + TABLE_CATEGORY + " (" +
                    CATEGORY_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    CATEGORY_COLUMN_NAME + " VARCHAR(25) NOT NULL, " +
                    "PRIMARY KEY(" + CATEGORY_COLUMN_ID +")" +
                    ");";

    public static final String CREATE_TABLE_WORKOUT_EXERCISE =
            "CREATE TABLE " + TABLE_WORKOUT_EXERCISE + " (" +
                    WORKOUT_EXERCISE_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    WORKOUT_EXERCISE_COLUMN_WORKOUT_ID + " int NOT NULL, " +
                    WORKOUT_EXERCISE_COLUMN_EXERCISE_ID + " int NOT NULL, " +
                    "FOREIGN KEY (" + WORKOUT_EXERCISE_COLUMN_WORKOUT_ID +")" +
                    " REFERENCES " + TABLE_WORKOUT +"(" +WORKOUT_COLUMN_ID +")," +
                    "FOREIGN KEY (" + WORKOUT_EXERCISE_COLUMN_EXERCISE_ID +")" +
                    " REFERENCES " + TABLE_EXERCISE +"(" +EXERCISE_COLUMN_ID +")," +
                    "PRIMARY KEY(" + WORKOUT_EXERCISE_COLUMN_ID +")" +
                    ");";
}
