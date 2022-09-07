package com.Mar.service.impl;

import com.Mar.beans.G_User;
import com.Mar.dao.G_UserDao;
import com.Mar.dao.impl.G_UserDaoImpl;
import com.Mar.service.G_UserService;

public class G_UserServiceImpl implements G_UserService {
    G_UserDao g_userDao = new G_UserDaoImpl();
    @Override
    public void addUser(G_User user) {
        g_userDao.addUser(user);
    }

    @Override
    public G_User getUserByName(String userName) {
        return g_userDao.getUserByName(userName);
    }

    @Override
    public G_User getUser(G_User user) {
        return g_userDao.getUser(user);
    }
}
