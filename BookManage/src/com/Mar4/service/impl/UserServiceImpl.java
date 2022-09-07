package com.Mar4.service.impl;

import com.Mar4.beans.User;
import com.Mar4.controller.BookController;
import com.Mar4.controller.KindController;
import com.Mar4.dao.BookDao;
import com.Mar4.dao.KindDao;
import com.Mar4.dao.UserDao;
import com.Mar4.dao.impl.BookDaoImpl;
import com.Mar4.dao.impl.KindDaoImpl;
import com.Mar4.dao.impl.UserDaoImpl;
import com.Mar4.service.UserService;
import com.Mar4.test.Test;
import com.Mar4.util.JDBCUtils;
import sun.security.x509.InvalidityDateExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    private static String sql = Test.sql;
    private static PreparedStatement ps = Test.ps;
    private static Connection conn = Test.conn;
    private static ResultSet rs = Test.rs;
    Scanner scanner = new Scanner(System.in);//数字类型
    Scanner scanner2 = new Scanner(System.in);//字符串
    BookDao bookDaoImpl = new BookDaoImpl();
    KindDao kindDao = new KindDaoImpl();
    UserDao userDao = new UserDaoImpl();



    @Override
    public boolean userLogin(User user) {//判断用户名密码匹配以及登录
        try {
            rs = userDao.userLogin(user);
            if (rs.next()) {
                if (user.getPassword().equals(rs.getString("password"))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
//        try {
//            conn = JDBCUtils.getConnection();
//            sql = "select * from  user where username = ?";
//            ps = conn.prepareStatement(sql);
//            ps.setString(1,user.getUserName());
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                if (user.getPassword().equals(rs.getString("password"))) {
//                    return true;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        JDBCUtils.release(conn,ps,rs);
//        return false;
    }

    @Override
    public boolean decideUserName(String userName) {//判断用户名是否存在
        boolean next = false;
        try {
            conn = JDBCUtils.getConnection();
            User user = new User();
            user.setUserName(userName);
            rs = userDao.userLogin(user);
            next = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.release(conn,ps,rs);
        return next;//不存在
    }


}
