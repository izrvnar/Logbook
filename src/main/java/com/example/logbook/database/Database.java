package com.example.logbook.database;


import java.sql.Connection;

public class Database {

    /**
     * This class is using a singleton pattern. So that the entire application is only
     * using one connection
     * We do this through the use of a private constructor and static instance variable
     * the static method getInstance will create/return the one instance of the database
     * class, allowing the application to only ever have one instance of the database class.
     */

    private static Database instance;
    private Connection connection = null;



}
