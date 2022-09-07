package com.Mar4.dao.impl;

import com.Mar4.beans.Kind;
import com.Mar4.dao.KindDao;
import com.Mar4.test.Test;
import com.Mar4.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KindDaoImpl implements KindDao {
    private static String sql = Test.sql;
    private static PreparedStatement ps = Test.ps;
    private static Connection conn = Test.conn;
    private static ResultSet rs = Test.rs;
    @Override
    public void addKind(Kind bkind) {
        try {
            conn = JDBCUtils.getConnection();
            sql = "insert into bkind values (null,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,bkind.getBname());
            if(decideKind(bkind.getBname())){
                ps.executeUpdate();
            }else {
                System.out.println("已有该类型！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.release(conn,ps,rs);
    }

    @Override
    public void deleteKind(int bid) {
        try {
            conn = JDBCUtils.getConnection();
            sql = "delete from bkind where bid = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bid);
            int i = ps.executeUpdate();
            if (i == 0){
                System.out.println("该类型不存在！");
            }else {
                System.out.println("删除成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.release(conn,ps,rs);
    }

    @Override
    public void updateKind(Kind bkind) {
        try {
            conn = JDBCUtils.getConnection();
            sql = "update book set bname = ? where bid = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, bkind.getBname());
            ps.setInt(6, bkind.getBid());
            int i = ps.executeUpdate();
            if (i == 0){
                System.out.println("该类型不存在！");
            }else {
                System.out.println("修改成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.release(conn,ps,rs);
    }

    @Override
    public ArrayList<Kind> getKind() {//查询全部种类
        ArrayList<Kind> kinds = new ArrayList<>();
        try{
            conn = JDBCUtils.getConnection();
            sql = "select * from bkind";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Kind kind = new Kind();
                kind.setBid(rs.getInt("bid"));
                kind.setBname(rs.getString("bname"));
                kinds.add(kind);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Kind getKind(int bid) {//通过bid查询类型
        try{
            conn = JDBCUtils.getConnection();
            sql = "select * from bkind where bid = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,bid);
            rs = ps.executeQuery();
            while (rs.next()){
                Kind kind = new Kind();
                kind.setBid(rs.getInt("bid"));
                kind.setBname(rs.getString("bname"));
                return kind;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean decideKind(String kind) {//判断种类是否存在
        boolean next = false;
        try {
            conn = JDBCUtils.getConnection();
            sql = "select * from bkind where bname = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, kind);
            rs = ps.executeQuery();
            next = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.release(conn,ps,rs);
        return next;
    }

}
