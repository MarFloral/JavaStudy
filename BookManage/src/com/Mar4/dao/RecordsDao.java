package com.Mar4.dao;

import com.Mar4.beans.Records;
import com.Mar4.beans.User;

import java.util.ArrayList;

public interface RecordsDao {
    void add(User user, String book);

    ArrayList<Records> select(User user);

    void dowm(int id);
}
