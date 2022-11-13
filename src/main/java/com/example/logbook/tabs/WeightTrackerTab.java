package com.example.logbook.tabs;

import javafx.scene.control.Tab;

public class WeightTrackerTab extends Tab {
    private static WeightTrackerTab instance;
    private WeightTrackerTab() {
        this.setText("Weight Tracker");
    }
    public static WeightTrackerTab getInstance(){
        if (instance == null){
            instance = new WeightTrackerTab();
        }
        return  instance;
    }
}
