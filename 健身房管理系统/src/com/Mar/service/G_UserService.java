package com.Mar.service;

import com.Mar.beans.G_User;

public interface G_UserService {
    void addUser(G_User user);

    G_User getUserByName(String userName);

    G_User getUser(G_User user);
}
