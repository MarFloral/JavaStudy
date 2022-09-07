package com.Mar.test;

import com.Mar.beans.Browser;
import com.Mar.beans.Editor;
import com.Mar.beans.RunCode;
import com.Mar.beans.Software;

public class Test {
    public void per(){

    }
    public static void main(String[] args) {
//        RunCode runCode = new RunCode();
//        System.out.println(runCode.runTime());
        Software s1 = new Browser();
        //s1.a();
        s1.end();
        s1.play();
        s1 = new Editor();
        s1.end();
        s1.play();
    }
}
