package com.Mar4.service.impl;

import com.Mar4.beans.Kind;
import com.Mar4.dao.BookDao;
import com.Mar4.dao.KindDao;
import com.Mar4.dao.UserDao;
import com.Mar4.dao.impl.BookDaoImpl;
import com.Mar4.dao.impl.KindDaoImpl;
import com.Mar4.dao.impl.UserDaoImpl;
import com.Mar4.service.KindService;
import com.Mar4.test.Test;
import com.Mar4.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class KindServiceImpl implements KindService {
    private static String sql = Test.sql;
    private static PreparedStatement ps = Test.ps;
    private static Connection conn = Test.conn;
    private static ResultSet rs = Test.rs;
    Scanner scanner = new Scanner(System.in);//数字类型
    Scanner scanner2 = new Scanner(System.in);//字符串
    BookDao bookDao = new BookDaoImpl();
    KindDao kindDao = new KindDaoImpl();
    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean decideKind(String kind) {//判断种类是否存在
        return kindDao.decideKind(kind);
    }

    @Override
    public void addKind(Kind kind) {
        kindDao.addKind(kind);
    }

    @Override
    public void deleteKind(int n) {
        kindDao.deleteKind(n);
    }

    @Override
    public void updateKind(Kind kind) {
        kindDao.updateKind(kind);
    }

    @Override
    public Kind getKind(int a) {
        return kindDao.getKind(a);
    }

    @Override
    public ArrayList<Kind> getKind() {
        return kindDao.getKind();
    }
}
