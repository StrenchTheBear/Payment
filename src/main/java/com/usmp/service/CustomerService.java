package com.usmp.service;

import com.usmp.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);
    List<Customer> findCustomers();
    Customer findById(Integer id);

}
