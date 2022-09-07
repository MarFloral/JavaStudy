package com.Mar.test;

import com.Mar.beans.Student;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.area(10));
        double area = student.area(10);
        System.out.println(area);
    }
}
