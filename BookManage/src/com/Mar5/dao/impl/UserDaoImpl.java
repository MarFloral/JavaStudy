package com.Mar5.dao.impl;

import com.Mar5.beans.User;
import com.Mar5.dao.UserDao;
import com.Mar5.test.Test;
import com.Mar5.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        finally {
            JDBCUtils.release(conn,ps,rs);
        }
    }

    @Override
    public int deleteUser(int id) {//注销账户
        int i = 0;
        try {
            conn = JDBCUtils.getConnection();
            sql = "delete from user where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,ps,rs);
        }
        return i;
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
        finally {
            JDBCUtils.release(conn,ps,rs);
        }
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
        }finally {
            JDBCUtils.release(conn,ps,rs);
        }
        return null;
    }

    @Override
    public ArrayList<User> selectUser() {
        ArrayList<User> users = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            sql = "select * from user ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAccess(rs.getString("access"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,ps,rs);
        }
        return users;
    }

    @Override
    public User getUser(User user1) {//通过id获得用户信息
        User user = null;
        try {
            conn = JDBCUtils.getConnection();
            sql = "select * from user where username = ? or id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user1.getUserName());
            ps.setInt(2,user1.getId());
            rs = ps.executeQuery();
            if (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAccess(rs.getString("access"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,ps,rs);
        }
        return user;
    }

    @Override
    public int update(User user) {//修改用户信息
        int i = 0;
        try {
            conn = JDBCUtils.getConnection();
            sql = "update user set username = ?, password = ?, access = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getAccess());
            ps.setInt(4,user.getId());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,ps,rs);
        }
        return i;
    }
}
