package com.usmp.service.Impl;

import com.usmp.entity.Card;
import com.usmp.service.CardService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private List<Card> cardList = null;

    public CardServiceImpl() {
        cardList = new LinkedList<>();

        Card card = new Card();

        card.setId(1);
        card.setCardNumber("4432887623316431");
        card.setCardName("Compras");
        card.setCardSecurityCode("621");
        card.setMaturyDate("09/23");
        card.setCardType("VISA");

        cardList.add(card);
    }

    @Override
    public boolean validateCard(String cardNumber) {
        return cardList.stream().anyMatch(card -> card.getCardNumber().equals(cardNumber));
    }

    @Override
    public void insertCustomerCard(Card card) {
        cardList.add(card);
    }

    @Override
    public List<Card> findCards() {
        return cardList;
    }

}
