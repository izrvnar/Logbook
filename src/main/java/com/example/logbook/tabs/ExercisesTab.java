package com.example.logbook.tabs;

import com.example.logbook.pojo.Categories;
import com.example.logbook.pojo.Exercise;
import com.example.logbook.tables.CategoryTable;
import com.example.logbook.tables.ExerciseTable;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class ExercisesTab extends Tab {
    private static ExercisesTab instance;
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
        //TODO: get categories from database and set them to the combobox
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

            exerciseTable.createExercise(exercise);
            System.out.println("Item added");
        });
        root.add(submit, 0, 5);
        this.setContent(root);


    }// end of class

    public static ExercisesTab getInstance(){
        if(instance == null){
            instance = new ExercisesTab();
        }
        return instance;
    }
}
