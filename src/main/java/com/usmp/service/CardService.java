package com.usmp.service;

import com.usmp.model.Card;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import com.usmp.repository.CardRepository;
@Service
public class CardService {

    private List<Card> cardList = null;
    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
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

    public boolean validateCard(String cardNumber) {
        return cardList.stream().anyMatch(card -> card.getCardNumber().equals(cardNumber));
    }

    public void insertCustomerCard(Card card) {
        cardList.add(card);
    }

    public List<Card> findCards() {
        return cardList;
    }

}
