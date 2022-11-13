package com.example.logbook.tabs;

import javafx.scene.control.Tab;

public class WorkoutTab extends Tab {
    private static WorkoutTab instance;
    private WorkoutTab() {
       this.setText("Workouts");
    }

    public static WorkoutTab getInstance(){
        if (instance == null){
            instance = new WorkoutTab();
        }
        return instance;
    }
}
