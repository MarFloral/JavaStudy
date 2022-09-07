package com.Mar4.service.impl;

import com.Mar4.beans.Book;
import com.Mar4.beans.Records;
import com.Mar4.beans.User;
import com.Mar4.dao.BookDao;
import com.Mar4.dao.RecordsDao;
import com.Mar4.dao.impl.BookDaoImpl;
import com.Mar4.dao.impl.RecordsDaoImpl;
import com.Mar4.service.RecordsService;

import java.util.ArrayList;

public class RecordsServiceImpl implements RecordsService {
    RecordsDao recordsDao = new RecordsDaoImpl();
    BookDao bookDao = new BookDaoImpl();

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
