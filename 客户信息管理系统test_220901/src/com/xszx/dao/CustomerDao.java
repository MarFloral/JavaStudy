package com.xszx.dao;

import com.xszx.beans.Customer;

import java.util.ArrayList;

public interface CustomerDao {
    //添加
    void add(Customer customer);

    //查询
    ArrayList<Customer> select();

    //通过id查询
    Customer selectById(int id);

    //修改信息
    void update(Customer customer);

    //删除
    void delete(int num);
}
