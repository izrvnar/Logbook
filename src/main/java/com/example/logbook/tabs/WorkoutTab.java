package com.example.logbook.tabs;

import com.example.logbook.pojo.DisplayExercise;
import com.example.logbook.pojo.DisplayWorkout;
import com.example.logbook.pojo.DisplayWorkoutExercise;
import com.example.logbook.pojo.Workout;
import com.example.logbook.tables.DisplayWorkoutExerciseTable;
import com.example.logbook.tables.WorkoutTable;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class WorkoutTab extends Tab {
    private static WorkoutTab instance;
    public TableView DisplayTableView;
    public TableView WorkoutTableView;

    private WorkoutTab() {
        ExercisesTab exercisesTab = new ExercisesTab();
        this.setText("Workouts");
        GridPane root = new GridPane();
        WorkoutTableView = new TableView<DisplayWorkout>();
        WorkoutTable workoutTable = new WorkoutTable();
        DisplayWorkoutExerciseTable displayWorkoutExerciseTable = new DisplayWorkoutExerciseTable();
        // text field for workout name
        TextField workoutName = new TextField();
        workoutName.setPromptText("Workout Name");
        root.add(workoutName, 0, 0);

        // datepicker for workout date
        DatePicker workoutDatePicker = new DatePicker();
        // setting default value for the current date
        workoutDatePicker.setValue(LocalDate.now());
        workoutDatePicker.setPromptText("Workout Date");
        //converting localtime to date
        LocalDate localDate = workoutDatePicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date workoutDate = Date.from(instant);
        Timestamp workoutTS = new Timestamp(workoutDate.getTime());



        root.add(workoutDatePicker, 0, 1);
        // button to add workout
        Button addWorkout = new Button("Add Workout");
        addWorkout.setOnAction(e -> {
            Workout workout = new Workout(
                    workoutName.getText(), workoutTS

            );

            workoutTable.createWorkout(workout);
            System.out.println("Workout Has Been Added");
            refreshWorkoutTable();

        });
        root.add(addWorkout, 0, 2);

        // button to delete workout
        Button deleteWorkout = new Button("Delete Workout");
        deleteWorkout.setOnAction(e -> {
            DisplayWorkout remove = (DisplayWorkout) WorkoutTableView.getSelectionModel().getSelectedItem();
            workoutTable.deleteWorkout(remove.getWorkout_id());
            System.out.println("Workout Has Been Deleted");
            refreshWorkoutTable();

        });
        //place button beside add workout button
        root.add(deleteWorkout, 1, 2);

        //create button to add selected exercise to work out
        Button addExercise = new Button("Add Exercise");
        addExercise.setOnAction(e -> {
                // get the selected workout
                DisplayWorkout selectedWorkout = (DisplayWorkout) WorkoutTableView.getSelectionModel().getSelectedItem();
                // get the selected exercise
                DisplayExercise selectedExercise = (DisplayExercise) exercisesTab.tableView.getSelectionModel().getSelectedItem();
                // create a new DisplayWorkoutExercise
                DisplayWorkoutExercise displayWorkoutExercise = new DisplayWorkoutExercise(selectedWorkout.getWorkout_id(), selectedExercise.getExercise_id());
//                displayWorkoutExerciseTable.addExerciseToWorkout(displayWorkoutExercise);


        });

        root.add(addExercise, 0, 3);

        TableColumn<DisplayWorkout, Integer> workoutColumn1 =
                new TableColumn<>("ID");
        workoutColumn1.setCellValueFactory(
                e-> new SimpleIntegerProperty(e.getValue().getWorkout_id()).asObject());

        TableColumn<DisplayWorkout, String> workoutColumn2 =
                new TableColumn<>("Name");
        workoutColumn2.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getName()));
//
        TableColumn<DisplayWorkout, Date> workoutColumn3 =
                new TableColumn<>("Date");
        workoutColumn3.setCellValueFactory(
                e-> new SimpleObjectProperty<>(e.getValue().getWorkout_date()));

        WorkoutTableView.getColumns().addAll(workoutColumn1, workoutColumn2, workoutColumn3);
        WorkoutTableView.getItems().addAll(workoutTable.getDisplayWorkoutItems());

        root.add(WorkoutTableView, 0,3);




        // add exercise tab to the workout tab
        root.add(exercisesTab.tableView, 1, 3);

        DisplayTableView = new TableView();
        TableColumn<DisplayExercise, String> column1 =
                new TableColumn<>("Name");
        column1.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getName()));

        TableColumn<DisplayExercise, Integer> column2 =
                new TableColumn<>("Sets");
        column2.setCellValueFactory(
                e-> new SimpleIntegerProperty(e.getValue().getSets()).asObject());

        TableColumn<DisplayExercise, Integer> column3 =
                new TableColumn<>("Reps");
        column3.setCellValueFactory(
                e-> new SimpleIntegerProperty(e.getValue().getReps()).asObject());

        TableColumn<DisplayExercise, Float> column4 =
                new TableColumn<>("Weight");
        column4.setCellValueFactory(
                e-> new SimpleFloatProperty( e.getValue().getWeight()).asObject());

        TableColumn<DisplayExercise, String> column5 =
                new TableColumn<>("Category");
        column5.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getCategory_name()));
        DisplayTableView.getColumns().addAll(column1, column2, column3, column4, column5);
        root.add(DisplayTableView, 4, 3);

        this.setContent(root);
    }

    public static WorkoutTab getInstance(){
        if (instance == null){
            instance = new WorkoutTab();
        }
        return instance;
    }

    //refresh workout table
    public void refreshWorkoutTable(){
        WorkoutTable workoutTable = new WorkoutTable();
        WorkoutTableView.getItems().clear();
        WorkoutTableView.getItems().addAll(workoutTable.getDisplayWorkoutItems());
    }


}
