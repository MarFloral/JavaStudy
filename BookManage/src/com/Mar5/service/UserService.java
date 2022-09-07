package com.Mar5.service;

import com.Mar5.beans.User;

import java.util.ArrayList;

public interface UserService {
    //判断用户名密码匹配以及登录
    boolean userLogin(User user);

    //判断用户名重复
    boolean decideUserName(String userName);

    ArrayList<User> userSelect();

    int delete(int id);

    User getUser(User user1);

    int update(User user1);
}
