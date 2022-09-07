package com.xszx.service;

import com.xszx.beans.Customer;

import java.util.ArrayList;

public interface CustomerService {
    //添加方法
    void add(Customer customer);

    //查询方法，返回集合
    ArrayList<Customer> select();

    //修改信息，传入客户对象
    void update(Customer customer);

    //通过id查询客户，返回客户对象
    Customer selectById(int id);

    //删除客户信息
    void delete(int num);
}
