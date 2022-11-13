package com.example.logbook.tabs;

import javafx.scene.control.Tab;

public class ExercisesTab extends Tab {
    private static ExercisesTab instance;
    private ExercisesTab() {
        this.setText("Exercises");
    }

    public static ExercisesTab getInstance(){
        if(instance == null){
            instance = new ExercisesTab();
        }
        return instance;
    }
}
