package com.usmp.service;

import com.usmp.model.Customer;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import com.usmp.repository.CustomerRepository;

@Service
public class CustomerService {

    private List<Customer> customerList = null;
    private CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository=customerRepository;
        customerList = new LinkedList<Customer>();
    }

    public void createCustomer(Customer customer) {
        customerList.add(customer);
    }

    public List<Customer> findCustomers() {
        return customerList;
    }

}
