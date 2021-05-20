package com.usmp.service.Impl;

import com.usmp.entity.Card;
import com.usmp.repository.CardRepository;
import com.usmp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    @Override
    public List<Card> findCards() {
        return this.cardRepository.findAll();
    }

    @Autowired
    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

}
