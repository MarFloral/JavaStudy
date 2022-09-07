package com.Mar5.dao;

import com.Mar5.beans.User;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface UserDao {
    void addUser(User user);
    //删除方法
    int deleteUser(int id);
    //修改方法
    void updatePassword(User user);

    ResultSet userLogin(User user);

    //判断权限
    String getAccess(User user);

    ArrayList<User> selectUser();

    User getUser(User user1);

    int update(User user1);
}
