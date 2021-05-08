package com.usmp.service;

import com.usmp.entity.Customer;

import java.util.List;

public interface CustomerService {

    void createCustomer(Customer customer);
    List<Customer> findCustomers();

}
