package com.example.demo.service;

import com.example.demo.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    public List<CustomerEntity> getCustomers();
    public CustomerEntity getCustomerByUsername(String username);
}
