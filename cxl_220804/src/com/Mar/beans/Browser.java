package com.Mar.beans;

public class Browser extends Software {
    public void a(){
        System.out.println("123");
    }
    @Override
    public void end() {
        System.out.println("Browser Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Browser Initialized!.");
    }

    @Override
    void start() {
        System.out.println("Browser Started.");
    }
}
