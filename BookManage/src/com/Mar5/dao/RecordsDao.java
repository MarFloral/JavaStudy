package com.Mar5.dao;

import com.Mar5.beans.Records;
import com.Mar5.beans.User;

import java.util.ArrayList;

public interface RecordsDao {
    void add(User user, String book);

    ArrayList<Records> select(User user);

    void dowm(int id);
}
