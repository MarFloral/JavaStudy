package com.Mar4.service;

import com.Mar4.beans.User;

public interface UserService {
    //判断用户名密码匹配以及登录
    boolean userLogin(User user);

    //判断用户名重复
    boolean decideUserName(String userName);

}
