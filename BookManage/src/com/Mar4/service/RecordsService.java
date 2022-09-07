package com.Mar4.service;

import com.Mar4.beans.Records;
import com.Mar4.beans.User;

import java.util.ArrayList;

public interface RecordsService {
    void add(User user, String id);

    ArrayList<Records> select(User user);

    void down(int id);
}
