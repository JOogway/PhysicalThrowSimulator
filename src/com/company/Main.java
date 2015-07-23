package com.company;

import com.company.Window.*;

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

    }
}
