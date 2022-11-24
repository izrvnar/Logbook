package com.example.logbook.database;


import java.sql.*;

import static com.example.logbook.database.Const.*;

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

    private Database(){
        //Connect to the database
        if(connection == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager
                        .getConnection("jdbc:mysql://localhost/"+ DB_NAME +
                                        "?serverTimezone=UTC",
                                DB_USER,
                                DB_PASS);
                System.out.println("Created connection");
                createTable(DBConst.TABLE_WORKOUT, DBConst.CREATE_TABLE_WORKOUT, connection);
                createTable(DBConst.TABLE_BODY_WEIGHT, DBConst.CREATE_TABLE_BODY_WEIGHT, connection);
                createTable(DBConst.TABLE_CATEGORY, DBConst.CREATE_TABLE_CATEGORY, connection);
                createTable(DBConst.TABLE_EXERCISE, DBConst.CREATE_TABLE_EXERCISE, connection);
                createTable(DBConst.TABLE_WORKOUT_EXERCISE, DBConst.CREATE_TABLE_WORKOUT_EXERCISE, connection);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    public void close(){
        System.out.println("Closing Connection");
        try{
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    /**
     * Create table method
     * @param tableName
     * @param tableQuery
     * @param connection
     * @throws SQLException
     */

    private void createTable(String tableName, String tableQuery,
                             Connection connection) throws SQLException {
        Statement createTable;
        //Get information from the database
        DatabaseMetaData md = connection.getMetaData();
        //Look in the database for a table that matches tableName
        ResultSet resultSet = md.getTables("eblanchettejava",
                null, tableName, null);
        if(resultSet.next()){
            System.out.println(tableName + " table already exists!");
        }
        else{
            createTable = connection.createStatement();
            createTable.execute(tableQuery);
            System.out.println("The " + tableName + " table has been created");
        }
    }

    // get connection method
    public Connection getConnection(){
        return connection;
    }





}
