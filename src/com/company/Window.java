package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

import static javafx.application.Application.launch;

/**
 * Created by Maksym on 2015-07-20.
 */
public class Window extends JFrame {
    XYChart.Series series;
    JPanel canvas;
    JLabel jlForce, jlHeight, jlMaxHeight;
    JTextField jfForce, jfHeight;
    String MaxHeight = "";

    public void Window() throws Exception {
       /* MyChart mc = new MyChart() {
            @Override
            protected void layoutChartChildren(double top, double left, double width, double height) {

            }
        };
*/
        setSize(1000,700);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        //mc.start();
        ChartInit();


    }
    public void ChartInit(){
        Labels();
        TextFields();
        Panel();
        getContentPane().add(jlForce);
        getContentPane().add(jlHeight);
        getContentPane().add(jlMaxHeight);
        getContentPane().add(jfForce);
        getContentPane().add(jfHeight);
        getContentPane().add(canvas);
        repaint();
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

        jlMaxHeight = new JLabel("Max wysokość");
        jlMaxHeight.setVisible(true);
        jlMaxHeight.setBounds(20, 500, 200, 25);
        jlMaxHeight.setFont(new Font("TimesNewRoman", Font.BOLD, 20));


    }
        public void TextFields() {
            jfForce = new JTextField("");
            jfForce.setVisible(true);
            jfForce.setBounds(20, 140, 150, 25);

            jfHeight = new JTextField("");
            jfHeight.setVisible(true);
            jfHeight.setBounds(20, 240, 150, 25);
        }
        public void Panel(){
            canvas = new JPanel();
            canvas.setVisible(true);
            canvas.setBounds(250,25,700,600);
            canvas.setBackground(Color.black);

        }
   /* public abstract class MyChart extends Chart {

         public void start(Stage stage) {
            stage.setTitle("Line Chart Sample");
            //defining the axes
            final NumberAxis xAxis = new NumberAxis();
            final NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Droga");
            yAxis.setLabel("Wysokość");
            //creating the chart
            final LineChart<Number,Number> lineChart =
                    new LineChart<Number,Number>(xAxis,yAxis);

            lineChart.setTitle("Rzut");
            //defining a series
            series = new XYChart.Series();
            series.setName("Tor");
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
            lineChart.setVisible(true);
            lineChart.setMaxSize(800,600);
            stage.setScene(scene);
            stage.show();
        }
    }*/
}






