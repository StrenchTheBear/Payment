package com.usmp.service;

import com.usmp.entity.Card;

import java.util.List;

public interface CardService {

    List<Card> findCards();
    Card findByCardNumberAndExpirationDateAndCvcCode(String cardNumber, String expirationDate, Integer cvcCode);

}
