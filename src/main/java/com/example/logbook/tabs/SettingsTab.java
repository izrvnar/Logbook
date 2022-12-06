package com.example.logbook.tabs;

import javafx.scene.control.Tab;

public class SettingsTab extends Tab {
    private static SettingsTab instance;
    private SettingsTab() {
        this.setText("Settings");
    }

    public static SettingsTab getInstance(){
        if (instance == null){
            instance = new SettingsTab();
        }
        return instance;
    }
}
