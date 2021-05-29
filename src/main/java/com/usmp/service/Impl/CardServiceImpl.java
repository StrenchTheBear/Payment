package com.usmp.service.Impl;

import com.usmp.entity.Card;
import com.usmp.repository.CardRepository;
import com.usmp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    @Override
    public List<Card> findCards() {
        return this.cardRepository.findAll();
    }

    @Override
    public Card findByNameAndCardNumberAndExpirationDate(String name, String cardNumber, String expirationDate) {
        return this.cardRepository.findByNameLikeAndCardNumberLikeAndExpirationDateLike(name, cardNumber, expirationDate).orElse(null);
    }

    @Override
    public List<Card> findCardsByNumbers(List<String> cardsNumber) {
        List<Card> cards = this.cardRepository.findByCardNumberIn(cardsNumber);
        if(isEmpty(cards)) {
            return null;
        }
        return cards;
    }

    @Override
    public Card findByCardNumber(String cardNumber) {
        return this.cardRepository.findByCardNumberLike(cardNumber).orElse(null);
    }

    @Autowired
    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

}
