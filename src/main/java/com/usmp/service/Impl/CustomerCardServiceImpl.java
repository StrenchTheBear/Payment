package com.usmp.service.Impl;

import com.usmp.entity.CustomerCard;
import com.usmp.repository.CustomerCardRepository;
import com.usmp.service.CustomerCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
public class CustomerCardServiceImpl implements CustomerCardService {

    private CustomerCardRepository customerCardRepository;

    @Override
    public CustomerCard insertCard(CustomerCard customerCard) {
        return this.customerCardRepository.save(customerCard);
    }

    @Override
    public List<CustomerCard> findCustomerCards(Integer customerId) {
        List<CustomerCard> customerCards = this.customerCardRepository.findByCustomer_Id(customerId);
        if(isEmpty(customerCards)) {
            return null;
        }
        return customerCards;
    }

    @Override
    public boolean findByCardNumber(String cardNumber) {
        return this.customerCardRepository.existsById(cardNumber);
    }

    @Override
    public void deleteByCustomerNumber(String cardNumber) {
        this.customerCardRepository.deleteByCardNumberLike(cardNumber);
    }

    @Autowired
    public void setCustomerCardRepository(CustomerCardRepository customerCardRepository) {
        this.customerCardRepository = customerCardRepository;
    }

}
