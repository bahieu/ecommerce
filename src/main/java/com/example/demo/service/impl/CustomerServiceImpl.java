package com.example.demo.service.impl;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CustomerEntity> getCustomers() {
        return (List<CustomerEntity>) customerRepository.findAll();
    }

    @Override
    public CustomerEntity getCustomerByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        return customerRepository.findById(user.getCustomerEntity().getId()).get();
    }
}
