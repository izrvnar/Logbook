package com.example.logbook.pojo;

import java.util.Date;

public class DatabaseItem {
    private int id;

    public DatabaseItem(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
