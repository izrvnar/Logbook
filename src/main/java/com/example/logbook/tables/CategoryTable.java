package com.example.logbook.tables;

import com.example.logbook.daos.CategoryDAO;
import com.example.logbook.database.DBConst;
import com.example.logbook.database.Database;
import com.example.logbook.pojo.Categories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryTable implements CategoryDAO {
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
}
