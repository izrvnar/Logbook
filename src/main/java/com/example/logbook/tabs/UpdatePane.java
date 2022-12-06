package com.example.logbook.tabs;

import com.example.logbook.pojo.Categories;
import com.example.logbook.pojo.DatabaseItem;
import com.example.logbook.pojo.Exercise;
import com.example.logbook.tables.CategoryTable;
import com.example.logbook.tables.ExerciseTable;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class UpdatePane extends GridPane {
    public int find(ArrayList<?> arrayList, int id){
        ArrayList<DatabaseItem> searchList = (ArrayList<DatabaseItem>) ((ArrayList<?>) arrayList);
        for(int i = 0; i < searchList.size(); i++){
            if(searchList.get(i).getId() == id){
                return i;
            }
        }
        return 0;
    }

    public UpdatePane(Exercise exercise){
        ArrayList<Categories> categoriesArrayList = CategoryTable.getInstance().getAllCategories();
        ExerciseTable exerciseTable = ExerciseTable.getInstance();
        Text name = new Text("Name");
        this.add(name,0,0);

        TextField nameField = new TextField(exercise.getName());
        this.add(nameField,1,0);

        Text sets = new Text("Sets");
        this.add(sets,0,1);

        TextField setsField = new TextField(String.valueOf(exercise.getSets()));
        this.add(setsField,1,1);

        Text reps = new Text("Reps");
        this.add(reps,0,2);
        TextField repsField = new TextField(String.valueOf(exercise.getReps()));
        this.add(repsField,1,2);

        Text weight = new Text("Weight");
        this.add(weight,0,3);
        TextField weightField = new TextField(String.valueOf(exercise.getWeight()));
        this.add(weightField,1,3);

        Text category = new Text("Category");
        this.add(category,0,4);
        ComboBox<Categories> categoryField = new ComboBox();
        categoryField.setItems(
                FXCollections.observableArrayList(
                        FXCollections.observableArrayList(categoriesArrayList)
                )
        );
        categoryField.getSelectionModel().select(find(categoriesArrayList, exercise.getCategory_id()));
        this.add(categoryField,1,4);

        Button updateButton = new Button("Update");
        updateButton.setOnAction(e -> {
            exercise.setName(nameField.getText());
            exercise.setSets(Integer.parseInt(setsField.getText()));
            exercise.setReps(Integer.parseInt(repsField.getText()));
            exercise.setWeight(Float.parseFloat(weightField.getText()));
            exercise.setCategory_id(categoryField.getSelectionModel().getSelectedItem().getCategory_id());
            exerciseTable.updateExercise(exercise, exercise.getCategory_id());

            ExercisesTab.getInstance().refreshTable();
            RoutineBreakdownTab.getInstance().generateChart();
            System.out.println("Updated");


        });

        this.add(updateButton,0,5);

    }


}
