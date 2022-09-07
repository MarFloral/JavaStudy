package com.xszx.service.impl;

import com.xszx.beans.Customer;
import com.xszx.dao.CustomerDao;
import com.xszx.dao.impl.CustomerDaoImpl;
import com.xszx.service.CustomerService;

import java.util.ArrayList;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public void add(Customer customer) {
        customerDao.add(customer);
    }

    @Override
    public ArrayList<Customer> select() {
        return customerDao.select();
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public Customer selectById(int id) {
        return customerDao.selectById(id);
    }

    @Override
    public void delete(int num) {
        customerDao.delete(num);
    }
}
