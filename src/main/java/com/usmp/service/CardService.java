package com.usmp.service;

import com.usmp.entity.Card;

import java.util.List;

public interface CardService {

    List<Card> findCards();
    Card findByNameAndCardNumberAndExpirationDate(String name, String cardNumber, String expirationDate);
    List<Card> findCardsByNumbers(List<String> cardsNumber);

}
