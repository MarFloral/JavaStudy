package com.Mar.dao.impl;

import com.Mar.beans.G_Equipment;
import com.Mar.beans.G_Records;
import com.Mar.beans.G_User;
import com.Mar.dao.G_RecordsDao;
import com.Mar.text.Test;
import com.Mar.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class G_RecordsDaoImpl implements G_RecordsDao {
    private static String sql = Test.sql;
    private static PreparedStatement ps = Test.ps;
    private static Connection conn = Test.conn;
    private static ResultSet rs = Test.rs;
    @Override
    public G_Records getRecord(G_User user) {
        G_Records records = null;
        try {
            conn = JDBCUtil.getConnection();
            sql = "select * from g_records where uname = ? and btime is null ";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            rs = ps.executeQuery();
            while (rs.next()){
                records = new G_Records();
                records.setId(rs.getInt("id"));
                records.setEname(rs.getString("ename"));
                records.setUname(rs.getString("uname"));
                records.setRtime(rs.getTimestamp("rtime"));
                records.setBtime(rs.getTimestamp("btime"));
                return records;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    @Override
    public void addRecords(G_User user, G_Equipment equipment) {//添加记录
        Date date = new Date();
        try {
            conn = JDBCUtil.getConnection();
            sql = "insert into g_records values (null,?,?,?,null )";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,equipment.getEname());
            ps.setTimestamp(3,new Timestamp(date.getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBtime(G_User user) {
        Date date = new Date();
        try {
            conn = JDBCUtil.getConnection();
            sql = "update g_records set btime = ? where uname = ? and btime is null ";
            ps = conn.prepareStatement(sql);
            ps.setTimestamp(1,new Timestamp(date.getTime()));
            ps.setString(2,user.getUserName());
            int i = ps.executeUpdate();
            if (i == 0){
                System.out.println("没有借过此器材");
            }else {
                System.out.println("归还成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<G_Records> select(G_User user) {
        ArrayList<G_Records> records = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            sql = "select * from g_records where uname = ?  ";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            rs = ps.executeQuery();
            while (rs.next()){
                G_Records record = new G_Records();
                record.setId(rs.getInt("id"));
                record.setEname(rs.getString("ename"));
                record.setUname(rs.getString("uname"));
                record.setRtime(rs.getTimestamp("rtime"));
                record.setBtime(rs.getTimestamp("btime"));
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
}
