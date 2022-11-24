package com.example.logbook.database;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Login extends Application {


    public static void writeFile() throws FileNotFoundException {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        Text login = new Text("Login");
        Text name = new Text("Name");
        TextField db_name = new TextField();
        Text pass = new Text("Password");
        TextField db_pass = new TextField();
        Text user = new Text("User");
        TextField db_user = new TextField();
        Button submit = new Button("Submit");

        submit.setOnAction(e->{
            try {
                writeFile();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });



        Scene scene = new Scene(root, 1024, 768);
        primaryStage.setTitle("Logbook");
        primaryStage.setScene(scene);
        primaryStage.show();
        launch();
    }
}
