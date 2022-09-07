package com.Mar.beans;

public class Color {
    private String name;

    public static final Color red = new Color("红色");
    public static final Color blue = new Color("蓝色");
    public static final Color green = new Color("绿色");

    private Color(){

    }
    private Color(String name){
        this.name = name;
    }
}
