package com.example.logbook;

import com.example.logbook.database.Database;
import com.example.logbook.tabs.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Database connection =   Database.getInstance(); //open connection

        BorderPane root = new BorderPane();
        // creating menu bar
        MenuBar menu = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu creditsMenu = new Menu("Credits");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e->{
            // adding method to close connection
            connection.close();
            System.exit(0);
        });
        fileMenu.getItems().add(exit);
        menu.getMenus().addAll(fileMenu, creditsMenu);
        // Create tab pane
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(WorkoutTab.getInstance(),ExercisesTab.getInstance(), ProgressTab.getInstance(), RoutineBreakdownTab.getInstance(), WeightTrackerTab.getInstance(), SettingsTab.getInstance());
        // setting the tabs to not be able to be closed
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

//        // Crud Labels
//        VBox crudLabels = new VBox();
//        crudLabels.setPadding(new Insets(10));
//        crudLabels.setSpacing(25);
//
//        // create workout text
//        Text createWorkoutText = new Text("Create Workout");
//        createWorkoutText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//
//
//        // Delete workout Text
//        Text deleteWorkoutText = new Text("Delete Workout");
//        deleteWorkoutText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//
//        //Update workout Text
//        Text updateWorkoutText = new Text("Update Workout");
//        updateWorkoutText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//
//
//        // Text added to vbox
//        crudLabels.getChildren().addAll(createWorkoutText, deleteWorkoutText, updateWorkoutText);
//
//        //creating the name and date labels and text fields
//        VBox nameDateBox = new VBox(25);
//        HBox nameTextBox = new HBox();
//        HBox dateTextBox = new HBox();
//        Text nameText = new Text("Name");
//        nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//
//        TextField nameField = new TextField("");
//        nameField.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//        nameTextBox.getChildren().addAll(nameText, nameField);
//
//        Text dateText = new Text("Date");
//        dateText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//
//        TextField dateField = new TextField("");
//        dateField.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//        dateTextBox.getChildren().addAll(dateText, dateField);
//
//        nameDateBox.getChildren().addAll(nameTextBox, dateTextBox);
//
//        HBox paneBottom = new HBox(20);
//        paneBottom.getChildren().addAll(crudLabels, nameDateBox);


        // Root additions
        root.setCenter(tabPane);
        root.setTop(menu);
        //Scene
        Scene scene = new Scene(root, 1024, 768);
        stage.setTitle("Logbook");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}