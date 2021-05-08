package com.usmp.service.Impl;

import com.usmp.entity.Customer;
import com.usmp.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private List<Customer> customerList = null;

    public CustomerServiceImpl() {
        customerList = new LinkedList<Customer>();
    }

    @Override
    public void createCustomer(Customer customer) {
        customerList.add(customer);
    }

}
