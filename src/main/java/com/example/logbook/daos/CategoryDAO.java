package com.example.logbook.daos;

import com.example.logbook.pojo.Categories;

import java.util.ArrayList;

public interface CategoryDAO {
    // get all categories
    ArrayList<Categories> getAllCategories();
    // get a single category
    Categories getCategory(int id);
}
