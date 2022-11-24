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


    public static void writeFile(TextField db_pass, TextField db_user) throws FileNotFoundException {
        File file = new File("login.txt");
        try{
            PrintWriter output = new PrintWriter(file);
            output.println(db_pass);
            output.println(db_user);
        }catch (Exception e){
            e.printStackTrace();
        }
        readFile();
    }

    public static void readFile() throws FileNotFoundException{

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        Text login = new Text("Login");
        Text pass = new Text("Password");
        TextField db_pass = new TextField();
        Text user = new Text("User");
        TextField db_user = new TextField();
        Button submit = new Button("Submit");

        submit.setOnAction(e->{
            try {
                writeFile(db_pass, db_user);
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
