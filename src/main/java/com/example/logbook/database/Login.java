package com.example.logbook.database;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Login {

    private TextField name;
    private PasswordField pass;
    private TextField user;

    public static void checkFile() throws FileNotFoundException {
        File file = new File("login.txt");
        if (!file.exists()){
            PrintWriter output = new PrintWriter(file);


        }
    }

}
