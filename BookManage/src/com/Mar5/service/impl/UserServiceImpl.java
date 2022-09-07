package com.Mar5.service.impl;

import com.Mar5.beans.User;
import com.Mar5.dao.UserDao;
import com.Mar5.dao.impl.UserDaoImpl;
import com.Mar5.service.UserService;
import com.Mar5.test.Test;
import com.Mar5.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserServiceImpl implements UserService {
    private static String sql = Test.sql;
    private static PreparedStatement ps = Test.ps;
    private static Connection conn = Test.conn;
    private static ResultSet rs = Test.rs;
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

    @Override
    public ArrayList<User> userSelect() {
        return userDao.selectUser();
    }

    @Override
    public int delete(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User getUser(User user1) {
        return userDao.getUser(user1);
    }

    @Override
    public int update(User user1) {
        return userDao.update(user1);
    }


}
