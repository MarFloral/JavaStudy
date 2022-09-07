package com.Mar5.dao.impl;

import com.Mar5.beans.Records;
import com.Mar5.beans.User;
import com.Mar5.dao.RecordsDao;
import com.Mar5.test.Test;
import com.Mar5.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class RecordsDaoImpl implements RecordsDao {
    private static String sql = Test.sql;
    private static PreparedStatement ps = Test.ps;
    private static Connection conn = Test.conn;
    private static ResultSet rs = Test.rs;

    @Override
    public void add(User user, String book) {
        Date date = new Date();
        try {
            conn = JDBCUtils.getConnection();
            sql = "insert into records values (null,?,?,?,null)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, book);
            ps.setTimestamp(3, new Timestamp(date.getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,ps,rs);
        }
    }

    @Override
    public ArrayList<Records> select(User user) {
        ArrayList<Records> records = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            sql = "select * from records where uname = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            rs = ps.executeQuery();
            while (rs.next()){
                Records record = new Records();
                record.setId(rs.getInt("id"));
                record.setUname(rs.getString("uname"));
                record.setBname(rs.getString("bname"));
                record.setRtime(rs.getTimestamp("rtime"));
                record.setBtime(rs.getTimestamp("btime"));
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,ps,rs);
        }
        return records;
    }

    @Override
    public void dowm(int id) {
        Date date = new Date();
        try {
            conn = JDBCUtils.getConnection();
            sql = "update records set btime = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setTimestamp(1,new Timestamp(date.getTime()));
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,ps,rs);
        }
    }
}
