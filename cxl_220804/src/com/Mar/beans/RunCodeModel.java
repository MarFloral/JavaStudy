package com.Mar.beans;

public abstract class RunCodeModel {
    public long runTime(){
        long begin = System.currentTimeMillis();
        runCode();
        long end = System.currentTimeMillis();//单位：毫秒
        long time = end - begin;
        return time;
    }
    public abstract void runCode();
}
