package com.Mar.test;

import com.Mar.beans.Student;
import com.Mar.beans.Teacher;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.study();
        //student.super.study();
        Teacher teacher = new Teacher();
        teacher.study();

    }
}

