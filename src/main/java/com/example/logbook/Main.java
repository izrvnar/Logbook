package com.example.logbook;

import com.example.logbook.tabs.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        // creating menu bar
        MenuBar menu = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu creditsMenu = new Menu("Credits");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e->{
            System.exit(0);
        });
        fileMenu.getItems().add(exit);
        menu.getMenus().addAll(fileMenu, creditsMenu);
        // Create tab pane
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(new WorkoutTab(), new ExercisesTab(), new ProgressTab(), new RoutineBreakdownTab(), new WeightTrackerTab(), new SettingsTab());
        // setting the tabs to not be able to be closed
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Crud Labels
        VBox crudLabels = new VBox();
        crudLabels.setPadding(new Insets(10));
        crudLabels.setSpacing(25);

        // create workout text
        Text createWorkoutText = new Text("Create Workout");
        createWorkoutText.setFont(Font.font("Arial", FontWeight.BOLD, 20));


        // Delete workout Text
        Text deleteWorkoutText = new Text("Delete Workout");
        deleteWorkoutText.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        //Update workout Text
        Text updateWorkoutText = new Text("Update Workout");
        updateWorkoutText.setFont(Font.font("Arial", FontWeight.BOLD, 20));


        // Text added to vbox
        crudLabels.getChildren().addAll(createWorkoutText, deleteWorkoutText, updateWorkoutText);


        // Root additions
        root.setCenter(tabPane);
        root.setTop(menu);
        root.setBottom(crudLabels);
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