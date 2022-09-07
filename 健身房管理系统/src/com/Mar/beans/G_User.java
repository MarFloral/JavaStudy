package com.Mar.beans;

public class G_User {
    private int id;//编号
    private String userName;//用户名
    private String password;//密码
    private String access;//权限

    public G_User() {
    }

    public G_User(int id, String userName, String password, String access) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.access = access;
    }

    public G_User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public G_User(String userName, String password, String access) {
        this.userName = userName;
        this.password = password;
        this.access = access;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", access='" + access + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
