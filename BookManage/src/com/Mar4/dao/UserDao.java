package com.Mar4.dao;

import com.Mar4.beans.User;

import java.sql.ResultSet;

public interface UserDao {
    void addUser(User user);
    //删除方法
    void deleteUser(String userName);
    //修改方法
    void updatePassword(User user);

    String getUser(User user);

    ResultSet userLogin(User user);

    //判断权限
    String getAccess(User user);
}
