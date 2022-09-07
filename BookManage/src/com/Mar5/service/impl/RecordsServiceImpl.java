package com.Mar5.service.impl;

import com.Mar5.beans.Records;
import com.Mar5.beans.User;
import com.Mar5.dao.RecordsDao;
import com.Mar5.dao.impl.RecordsDaoImpl;
import com.Mar5.service.RecordsService;

import java.util.ArrayList;

public class RecordsServiceImpl implements RecordsService {
    RecordsDao recordsDao = new RecordsDaoImpl();

    @Override
    public void add(User user, String name) {
        recordsDao.add(user, name);
    }

    @Override
    public ArrayList<Records> select(User user) {
        return recordsDao.select(user);
    }

    @Override
    public void down(int id) {
        recordsDao.dowm(id);
    }
}
