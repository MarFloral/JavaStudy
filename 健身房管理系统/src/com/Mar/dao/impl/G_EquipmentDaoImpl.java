package com.Mar.dao.impl;

import com.Mar.beans.G_Equipment;
import com.Mar.dao.G_EquipmentDao;
import com.Mar.text.Test;
import com.Mar.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class G_EquipmentDaoImpl implements G_EquipmentDao {
    private static String sql = Test.sql;
    private static PreparedStatement ps = Test.ps;
    private static Connection conn = Test.conn;
    private static ResultSet rs = Test.rs;
    @Override
    public void addEquipment(G_Equipment equipment) {
        try {
            conn = JDBCUtil.getConnection();
            sql = "insert into g_equipment values (null,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, equipment.getEname());
            ps.setString(2, "闲置中");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.release(conn,ps,rs);
    }

    @Override
    public ArrayList<G_Equipment> getEquipment() {
        ArrayList<G_Equipment> equipments = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            sql = "select * from g_equipment";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                G_Equipment equipment = new G_Equipment();
                equipment.setId(rs.getInt("id"));
                equipment.setEname(rs.getString("ename"));
                equipment.setStatus(rs.getString("status"));
                equipments.add(equipment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.release(conn,ps,rs);
        return equipments;
    }

    @Override
    public void delete(int n) {
        try {
            conn = JDBCUtil.getConnection();
            sql = "delete from g_equipment where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,n);
            int i = ps.executeUpdate();
            if (i == 0){
                System.out.println("该器材不存在！");
            }else {
                System.out.println("删除成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.release(conn,ps,rs);
    }

    @Override
    public void updateEquipment(G_Equipment equipment) {
        try {
            conn = JDBCUtil.getConnection();
            sql = "update g_equipment set ename = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,equipment.getEname());
            ps.setInt(2,equipment.getId());
            int i = ps.executeUpdate();
            if (i == 0){
                System.out.println("该器材不存在！");
            }else {
                System.out.println("修改成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.release(conn,ps,rs);
    }

    @Override
    public G_Equipment getEquipmentById(int id) {
        G_Equipment equipment = null;
        try {
            conn = JDBCUtil.getConnection();
            sql = "select * from g_equipment where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                equipment = new G_Equipment();
                equipment.setId(rs.getInt("id"));
                equipment.setEname(rs.getString("ename"));
                equipment.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.release(conn,ps,rs);
        return equipment;
    }

    @Override
    public void updateStatus(G_Equipment equipment) {
        try {
            conn = JDBCUtil.getConnection();
            sql = "update g_equipment set status = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"使用中");
            ps.setInt(2,equipment.getId());
            int i = ps.executeUpdate();
            if (i == 0){
                System.out.println("该器材不存在！");
            }else {
                System.out.println("使用成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.release(conn,ps,rs);
    }

    @Override
    public void updateStatus(String ename) {
        try {
            conn = JDBCUtil.getConnection();
            sql = "update g_equipment set status = ? where ename = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"闲置中");
            ps.setString(2,ename);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.release(conn,ps,rs);
    }
}
