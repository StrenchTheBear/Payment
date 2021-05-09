package com.usmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usmp.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
    
}
