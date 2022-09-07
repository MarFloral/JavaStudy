package com.Mar5.service;

import com.Mar5.beans.Records;
import com.Mar5.beans.User;

import java.util.ArrayList;

public interface RecordsService {
    void add(User user, String id);

    ArrayList<Records> select(User user);

    void down(int id);
}
