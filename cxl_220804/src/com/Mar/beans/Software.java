package com.Mar.beans;

public abstract class Software {
    abstract void initialize();
    abstract void start();
    public abstract void end();
    //模板方法
    public final void play(){
        //        //initialize
        initialize();
        //start
        start();
        //end
        end();
    }
}