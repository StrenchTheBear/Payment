package com.usmp.service;

import com.usmp.entity.CustomerCard;

import java.util.List;

public interface CustomerCardService {

    CustomerCard insertCard(CustomerCard customerCard);
    List<CustomerCard> findCustomerCards(Integer customerId);
    boolean findByCardNumber(String cardNumber);
    void deleteByCustomerNumber(String cardNumber);

}
