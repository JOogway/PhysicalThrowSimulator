package com.company;

import com.company.Window.*;

import com.company.Window.LineChartSample;
import com.sun.glass.ui.Application;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Main {

    public static void main(String[] args) throws Exception, IOException {

	Window main = new Window();
        try {
            main.Window();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LineChartSample LCS = new LineChartSample(Application);

    }
}
