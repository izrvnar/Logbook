package com.example.logbook.tabs;

import com.example.logbook.pojo.BodyWeight;
import com.example.logbook.tables.BodyWeightTable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class WeightTrackerTab extends Tab {

    private static WeightTrackerTab instance;

    private final LineChart<Number, Number> lineChart;
    private WeightTrackerTab() {
        this.setText("Weight Tracker");
        BorderPane root = new BorderPane();
        lineChart = new LineChart<Number, Number>(new NumberAxis(), new NumberAxis());
        lineChart.setTitle("Weight Tracker");
        lineChart.setCreateSymbols(true);



        BodyWeightTable bodyWeightTable = new BodyWeightTable();


        // textfield for weight
        TextField weightField = new TextField();
        weightField.setPromptText("Enter weight");

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            BodyWeight bodyWeight = new BodyWeight(0, Float.parseFloat(weightField.getText()), new Timestamp(new Date().getTime()));
            bodyWeightTable.createBodyWeight(bodyWeight);
            System.out.println("Weight added");
            generateChart();
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(weightField, submitButton);
        hBox.setAlignment(Pos.CENTER);
        // setting hbox bottom padding
        hBox.setPadding(new Insets(0, 0, 20, 0));
        root.setBottom(hBox);


        root.setCenter(lineChart);
        generateChart();
        this.setContent(root);
    }
    public static WeightTrackerTab getInstance(){
        if (instance == null){
            instance = new WeightTrackerTab();
        }
        return  instance;
    }



    public void generateChart(){
        BodyWeightTable bodyWeightTable = BodyWeightTable.getInstance();
        ArrayList<BodyWeight> bodyWeights = bodyWeightTable.getAllWeights();
        Collections.sort(bodyWeights);

        int i = 1;

        for(BodyWeight bodyWeight : bodyWeights){
            float weight = bodyWeight.getWeight();
            Timestamp timestamp = bodyWeight.getDate_weight();
            //get the current date
            Date date = new Date();
            date.getTime();

            // minus the date from the timestamp
            long diff = date.getTime() - timestamp.getTime();
            //convert to days
            long diffDays = diff / (24 * 60 * 60 * 1000);

            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data(i, weight));
            System.out.println(diffDays + " " + weight);
            lineChart.getData().add(series);

            //naming x axis
            lineChart.getXAxis().setLabel("Days");
            //naming y axis
            lineChart.getYAxis().setLabel("Weight");
            i++;
        }

    }
}
