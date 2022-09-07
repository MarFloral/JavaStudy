package com.Mar.dao.impl;

import com.Mar.beans.G_User;
import com.Mar.dao.G_UserDao;
import com.Mar.text.Test;
import com.Mar.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class G_UserDaoImpl implements G_UserDao {
    private static String sql = Test.sql;
    private static PreparedStatement ps = Test.ps;
    private static Connection conn = Test.conn;
    private static ResultSet rs = Test.rs;
    @Override
    public void addUser(G_User user) {
        try {
            conn = JDBCUtil.getConnection();
            sql = "insert into g_user values (null,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getAccess());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.release(conn,ps,rs);
    }

    @Override
    public G_User getUserByName(String userName) {
        try {
            conn = JDBCUtil.getConnection();
            sql = "select * from g_user where uname = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            rs= ps.executeQuery();
            while (rs.next()){
                G_User g_user = new G_User();
                g_user.setId(rs.getInt("id"));
                g_user.setUserName(rs.getString("uname"));
                g_user.setPassword(rs.getString("password"));
                g_user.setAccess(rs.getString("access"));
                return g_user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.release(conn,ps,rs);
        return null;
    }

    @Override
    public G_User getUser(G_User user) {
        try {
            conn = JDBCUtil.getConnection();
            sql = "select * from g_user where uname = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            rs= ps.executeQuery();
            while (rs.next()){
                user = new G_User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("uname"));
                user.setPassword(rs.getString("password"));
                user.setAccess(rs.getString("access"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.release(conn,ps,rs);
        return null;
    }
}
