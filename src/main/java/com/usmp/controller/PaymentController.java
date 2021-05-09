package com.usmp.controller;

import com.usmp.model.Customer;
import com.usmp.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private CustomerService customerService;

    public PaymentController(CustomerService customerService){
        this.customerService=customerService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findCustomers() {
        return this.customerService.findCustomers();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody Customer customer) {
        this.customerService.createCustomer(customer);
    }


}
