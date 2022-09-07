package com.Mar.beans;

import com.Mar.dao.Dao;

public enum Color01 implements Dao {
    RED("红色"){
        @Override
        public void run() {
            System.out.println("红色");
        }
    },GREEN("绿色") {
        @Override
        public void run() {
            System.out.println("绿色");
        }
    },BLUE("蓝色") {
        @Override
        public void run() {
            System.out.println("蓝色");
        }
    },OTHER{
        public void run(){
            System.out.println();
        }
    };

    private String name;
    private Color01(){

    }
    private Color01(String name){
        this.name = name;
    }

    public void run(){
        System.out.println("");
    }
    @Override
    public String toString() {
        return "Color01{" +
                "name='" + name + '\'' +
                '}';
    }
}
