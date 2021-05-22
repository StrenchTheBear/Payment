package com.usmp.service.Impl;

import com.usmp.entity.CustomerCard;
import com.usmp.repository.CustomerCardRepository;
import com.usmp.service.CustomerCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCardServiceImpl implements CustomerCardService {

    private CustomerCardRepository customerCardRepository;

    @Override
    public CustomerCard insertCard(CustomerCard customerCard) {
        return this.customerCardRepository.save(customerCard);
    }

    @Autowired
    public void setCustomerCardRepository(CustomerCardRepository customerCardRepository) {
        this.customerCardRepository = customerCardRepository;
    }

}
