package com.Mar4.dao.impl;

import com.Mar4.beans.User;
import com.Mar4.dao.UserDao;
import com.Mar4.test.Test;
import com.Mar4.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private static String sql = Test.sql;
    private static PreparedStatement ps = Test.ps;
    private static Connection conn = Test.conn;
    private static ResultSet rs = Test.rs;

    @Override
    public void addUser(User user) {//注册账户
        try {
            conn = JDBCUtils.getConnection();
            sql = "insert into user values (null,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getAccess());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.release(conn,ps,rs);
    }

    @Override
    public void deleteUser(String userName) {//注销账户
        try {
            conn = JDBCUtils.getConnection();
            sql = "delete from user where userName = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.release(conn,ps,rs);
    }

    @Override
    public void updatePassword(User user) {//修改密码
        try {
            conn = JDBCUtils.getConnection();
            sql = "update user set password = ? where username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getPassword());
            ps.setString(2,user.getUserName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.release(conn,ps,rs);
    }

    @Override
    public String getUser(User user){
        try {
            conn = JDBCUtils.getConnection();
            sql = "select * from user where username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.release(conn,ps,rs);
        return null;
    }

    @Override
    public ResultSet userLogin(User user) {//判断用户名密码匹配以及登录
        try {
            conn = JDBCUtils.getConnection();
            sql = "select * from  user where username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public String getAccess(User user) {
        try {
            conn = JDBCUtils.getConnection();
            sql = "select * from user where username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            rs = ps.executeQuery();
            if (rs.next()){
                String access = rs.getString("access");
                if (access.equals("管理员")){
                    return "管理员";
                }else {
                    return "会员";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.release(conn,ps,rs);
        return null;
    }
}
