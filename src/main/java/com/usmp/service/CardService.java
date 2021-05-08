package com.usmp.service;

import com.usmp.entity.Card;

import java.util.List;

public interface CardService {

    List<Card> findCards();
    boolean validateCard(String cardNumber);
    void insertCustomerCard(Card card);

}
