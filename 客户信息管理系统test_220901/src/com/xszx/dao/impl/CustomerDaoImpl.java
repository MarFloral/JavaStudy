package com.xszx.dao.impl;

import com.xszx.beans.Customer;
import com.xszx.dao.CustomerDao;
import com.xszx.utile.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerDaoImpl implements CustomerDao {
    private Connection conn = null;//连接
    private PreparedStatement ps = null;//操作对象
    private ResultSet rs = null;//查询返回
    private String sql = null;//sql语句

    @Override
    public void add(Customer customer) {//添加
        try {
            conn = JDBCUtils.getConnection();
            sql = "insert into customer values (null,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getNaem());
            ps.setString(2, customer.getSex());
            ps.setInt(3, customer.getAge());
            ps.setString(4, customer.getTel());
            ps.setString(5, customer.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.close(conn,ps,rs);
    }

    @Override
    public ArrayList<Customer> select() {//查询
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            sql = "select * from customer";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setNaem(rs.getString("naem"));
                customer.setSex(rs.getString("sex"));
                customer.setAge(rs.getInt("age"));
                customer.setTel(rs.getString("tel"));
                customer.setEmail(rs.getString("email"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.close(conn,ps,rs);
        return customers;
    }

    @Override
    public Customer selectById(int id) {//通过id查询
        Customer customer = null;
        try {
            conn = JDBCUtils.getConnection();
            sql = "select * from customer where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()){
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setNaem(rs.getString("naem"));
                customer.setSex(rs.getString("sex"));
                customer.setAge(rs.getInt("age"));
                customer.setTel(rs.getString("tel"));
                customer.setEmail(rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.close(conn,ps,rs);
        return customer;
    }

    @Override
    public void update(Customer customer) {//修改
        try {
            conn = JDBCUtils.getConnection();
            sql = "update customer set naem = ?, sex = ?, age = ?, tel = ?, email = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,customer.getNaem());
            ps.setString(2,customer.getSex());
            ps.setInt(3,customer.getAge());
            ps.setString(4,customer.getTel());
            ps.setString(5,customer.getEmail());
            ps.setInt(6,customer.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.close(conn,ps,rs);
    }

    @Override
    public void delete(int num) {//删除
        try {
            conn = JDBCUtils.getConnection();
            sql = "delete from customer where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,num);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.close(conn,ps,rs);
    }
}
