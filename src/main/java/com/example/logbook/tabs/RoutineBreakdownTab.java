package com.example.logbook.tabs;

import com.example.logbook.pojo.Categories;
import com.example.logbook.tables.CategoryTable;
import com.example.logbook.tables.ExerciseTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.Observable;

public class RoutineBreakdownTab extends Tab {
    private static RoutineBreakdownTab instance;

    private PieChart pieChart;
    private RoutineBreakdownTab() {
        this.setText("Routine Breakdown");
        BorderPane root = new BorderPane();
        pieChart = new PieChart();
        pieChart.setTitle("Routine Breakdown");
        pieChart.setLabelsVisible(true);
        root.setCenter(pieChart);
        generateChart();
        this.setContent(root);

    }

    public static RoutineBreakdownTab getInstance(){
        if (instance == null){
            instance = new RoutineBreakdownTab();
        }
        return instance;
    }

    public void generateChart(){
        CategoryTable categoryTable = new CategoryTable();
        ExerciseTable exerciseTable = new ExerciseTable();
        ArrayList<Categories> categories = categoryTable.getAllCategories();
        ArrayList<PieChart.Data> data = new ArrayList<>();

        for (Categories category : categories){
            double count = exerciseTable.getCategoryCount(category.getCategory_id());
            if (count > 0){
                data.add(new PieChart.Data(category.getName(), count));
            }
        }
        ObservableList<PieChart.Data> chartData
                = FXCollections.observableArrayList(data);
        pieChart.setData(chartData);
    }
}
