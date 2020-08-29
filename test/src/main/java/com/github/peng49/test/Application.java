package com.github.peng49.test;

import com.github.peng49.framework.starter.MainApplication;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Hello spring!");
        MainApplication.run(Application.class, args);
    }
}
