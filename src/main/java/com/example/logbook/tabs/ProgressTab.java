package com.example.logbook.tabs;

import javafx.scene.control.Tab;

public class ProgressTab extends Tab {
    private static ProgressTab instance;
    private ProgressTab() {
        this.setText("Progress");
    }

    public static ProgressTab getInstance(){
        if (instance == null){
            instance = new ProgressTab();
        }
        return instance;
    }
}
