package com.xszx.beans;

public class Customer {
    private int id;//编号
    private String naem;//名字
    private String sex;//性别
    private int age;//年龄
    private String tel;//电话
    private String email;//邮箱

    public Customer() {
    }

    public Customer(int id, String naem, String sex, int age, String tel, String email) {
        this.id = id;
        this.naem = naem;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.email = email;
    }

    public Customer(String naem, String sex, int age, String tel, String email) {
        this.naem = naem;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  id +
                "\t\t" + naem +
                "\t" + sex +
                "\t\t" + age +
                "\t\t" + tel +
                "\t" + email;
    }
}
