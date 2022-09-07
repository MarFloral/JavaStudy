package com.Mar.beans;

public class Student {
    public int id;//学号
    public String name;//姓名
    public char gender;//性别
    public double height;//身高
    public double weight;//体重
    public String score;//课程
    public int chinese;
    public int math;
    public int english;

    //成员方法
    public void study(){
        System.out.println(name+"学生爱学习");
    }
    public String study2(){
        return name+"爱学习"+score;
    }

    public int score() {
        return chinese+math+english;
    }
    public int score2(short a) {
        return chinese+math+english+a;
    }
//    public int sum(int[] a){
//        int sum = 0;
//        for (int i = 0; i < a.length; i++) {
//            sum += a[i];
//        }
//        return sum;
//    }

    public void sum(String... a){
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
            //sum += a[i];
        }
        //return sum;
    }
}
