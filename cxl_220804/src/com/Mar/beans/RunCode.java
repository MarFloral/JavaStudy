package com.Mar.beans;

public class RunCode {
    public static RunCode runCode = new RunCode();
    private RunCode(){

    }
    public RunCode getRunCode(){
        return runCode;
    }

//    @Override
//    public void runCode() {
//        for (int i = 0; i < 100; i++) {
//            System.out.println("i = " + i);
//        }
//    }
}
