package com.example.logbook.tabs;

import javafx.scene.control.Tab;

public class RoutineBreakdownTab extends Tab {
    private static RoutineBreakdownTab instance;
    private RoutineBreakdownTab() {
        this.setText("Routine Breakdown");
    }

    public static RoutineBreakdownTab getInstance(){
        if (instance == null){
            instance = new RoutineBreakdownTab();
        }
        return instance;
    }
}
