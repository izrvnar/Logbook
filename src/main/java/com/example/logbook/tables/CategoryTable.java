package com.example.logbook.tables;

import com.example.logbook.daos.CategoryDAO;
import com.example.logbook.database.DBConst;
import com.example.logbook.database.Database;
import com.example.logbook.pojo.Categories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryTable implements CategoryDAO {

    private static CategoryTable instance;

    Database db = Database.getInstance();
    @Override
    public ArrayList<Categories> getAllCategories() {
        String query = "SELECT * FROM " + DBConst.TABLE_CATEGORY;
        ArrayList<Categories> categories = new ArrayList<>();
        try {
            Statement getCategories = db.getConnection().createStatement();
            ResultSet data = getCategories.executeQuery(query);
            while (data.next()){
                categories.add(new Categories(
                        data.getInt(DBConst.CATEGORY_COLUMN_ID),
                        data.getString(DBConst.CATEGORY_COLUMN_NAME)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Categories getCategory(int id) {
        return null;
    }

    public int getCategoryCount(int category){
        int count = -1;
        try{
            PreparedStatement getCount = db.getConnection().prepareStatement("SELECT * FROM " + DBConst.TABLE_CATEGORY + " WHERE "+ DBConst.CATEGORY_COLUMN_NAME + " = " + category +"", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet data = getCount.executeQuery();
            data.last();
            count =  data.getRow();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public static CategoryTable getInstance(){
        if(instance == null){
            instance = new CategoryTable();
        }
        return instance;
    }
}
