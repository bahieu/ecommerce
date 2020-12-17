package com.example.demo.repository;

import com.example.demo.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity,Integer> {
}
