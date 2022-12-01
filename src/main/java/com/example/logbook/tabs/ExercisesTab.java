package com.example.logbook.tabs;

import com.example.logbook.pojo.Categories;
import com.example.logbook.pojo.DisplayExercise;
import com.example.logbook.pojo.Exercise;
import com.example.logbook.tables.CategoryTable;
import com.example.logbook.tables.ExerciseTable;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class ExercisesTab extends Tab {
    private static ExercisesTab instance;
    public TableView tableView;
    private ExercisesTab() {
        this.setText("Exercises");
        ExerciseTable exerciseTable = new ExerciseTable();
        CategoryTable categoryTable = new CategoryTable();
        GridPane root = new GridPane();

        //getting name of exercise
        Text name = new Text("Name: ");
        TextField nameField = new TextField();
        root.add(name, 0, 0);
        root.add(nameField, 1, 0);

        //gettings sets
        Text sets = new Text("Sets: ");
        TextField setsField = new TextField();
        root.add(sets, 0, 1);
        root.add(setsField, 1, 1);

        //getting reps
        Text reps = new Text("Reps: ");
        TextField repsField = new TextField();
        root.add(reps, 0, 2);
        root.add(repsField, 1, 2);

        //getting weight
        Text weight = new Text("Weight: ");
        TextField weightField = new TextField();
        root.add(weight, 0, 3);
        root.add(weightField, 1, 3);

        //getting category
        Text category = new Text("Category: ");
        ComboBox<Categories> categoryField = new ComboBox();
        categoryField.setItems(
                FXCollections.observableArrayList(
                        categoryTable.getAllCategories()
                )
        );
        root.add(category, 0, 4);
        root.add(categoryField, 1, 4);

        // Submit button
        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
            Exercise exercise = new Exercise(
                    nameField.getText(),
                    Integer.parseInt(setsField.getText()),
                    Integer.parseInt(repsField.getText()),
                    Integer.parseInt(weightField.getText()),
                    categoryField.getSelectionModel().getSelectedItem().getCategory_id()
            );

            clearFields(nameField, setsField, repsField, weightField, categoryField);


            exerciseTable.createExercise(exercise);
            System.out.println("Item added");
            RoutineBreakdownTab.getInstance().generateChart();
            refreshTable();
        });

        Button delete = new Button("Delete");
        delete.setOnAction(e -> {
            DisplayExercise remove = (DisplayExercise) tableView.getSelectionModel().getSelectedItem();
            exerciseTable.deleteExercise(remove.getExercise_id());
            System.out.println("Item deleted");
            RoutineBreakdownTab.getInstance().generateChart();
            refreshTable();


        });
        root.add(delete, 1, 5);
        root.add(submit, 0, 5);

        tableView = new TableView();
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
        tableView.getColumns().addAll(column1, column2, column3, column4, column5);
        tableView.getItems().addAll(exerciseTable.getDisplayExericeItems());
        // add tableview to right side of gridpane
        root.add(tableView, 2, 0, 1, 6);

        this.setContent(root);


    }// end of class

    public void refreshTable(){
        ExerciseTable table = new ExerciseTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(table.getDisplayExericeItems());
    }

    private static void clearFields(TextField nameField, TextField setsField, TextField repsField, TextField weightField, ComboBox<Categories> categoryField) {
        //clearing fields
        nameField.clear();
        setsField.clear();
        repsField.clear();
        weightField.clear();
        categoryField.getSelectionModel().clearSelection();
    }


    public static ExercisesTab getInstance(){
        if(instance == null){
            instance = new ExercisesTab();
        }
        return instance;
    }



}
