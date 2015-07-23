package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

import static javafx.application.Application.launch;

/**
 * Created by Maksym on 2015-07-20.
 */
public class Window extends JFrame {

    JLabel jlForce, jlHeight, jlMaxHeight;
    String MaxHeight = "";

    public void Window() throws Exception {


        setSize(1280, 1024);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        Labels();
        getContentPane().setLayout(null);
        getContentPane().add(jlForce);
        getContentPane().add(jlHeight);
        getContentPane().add(jlMaxHeight);


    }

    public void Labels() {
        jlForce = new JLabel("Siła");
        jlForce.setVisible(true);
        jlForce.setBounds(20, 100, 200, 25);
        jlForce.setFont(new Font("TimesNewRoman", Font.BOLD, 20));


        jlHeight = new JLabel("Wysokość");
        jlHeight.setVisible(true);
        jlHeight.setBounds(20, 200, 200, 25);
        jlHeight.setFont(new Font("TimesNewRoman", Font.BOLD, 20));

        jlMaxHeight = new JLabel("Maksymalna wysokość");
        jlMaxHeight.setVisible(true);
        jlMaxHeight.setBounds(20, 800, 250, 25);
        jlMaxHeight.setFont(new Font("TimesNewRoman", Font.BOLD, 20));


    }
    public class LineChartSample extends Application {

        @Override public void start(Stage stage) {
            stage.setTitle("Line Chart Sample");
            //defining the axes
            final NumberAxis xAxis = new NumberAxis();
            final NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Number of Month");
            //creating the chart
            final LineChart<Number,Number> lineChart =
                    new LineChart<Number,Number>(xAxis,yAxis);

            lineChart.setTitle("Stock Monitoring, 2010");
            //defining a series
            XYChart.Series series = new XYChart.Series();
            series.setName("My portfolio");
            //populating the series with data
            series.getData().add(new XYChart.Data(1, 23));
            series.getData().add(new XYChart.Data(2, 14));
            series.getData().add(new XYChart.Data(3, 15));
            series.getData().add(new XYChart.Data(4, 24));
            series.getData().add(new XYChart.Data(5, 34));
            series.getData().add(new XYChart.Data(6, 36));
            series.getData().add(new XYChart.Data(7, 22));
            series.getData().add(new XYChart.Data(8, 45));
            series.getData().add(new XYChart.Data(9, 43));
            series.getData().add(new XYChart.Data(10, 17));
            series.getData().add(new XYChart.Data(11, 29));
            series.getData().add(new XYChart.Data(12, 25));

            Scene scene  = new Scene(lineChart,800,600);
            lineChart.getData().add(series);

            stage.setScene(scene);
            stage.show();
        }
    }
}






