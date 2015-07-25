package com.company;


import java.io.IOException;

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
