package com.usmp.controller;

import com.usmp.entity.Card;
import com.usmp.service.CardService;
import com.usmp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {

    private CardService cardService;
    private CustomerService customerService;

    @PostMapping("/insert")
    public ResponseEntity<String> insertCard(@RequestBody Card card) {
        boolean existCard = this.cardService.findCards().stream().anyMatch(cardFromDB -> cardFromDB.getCardNumber().equals(card.getCardNumber()));
        if(!existCard) {
            return new ResponseEntity<>("El número de tarjeta ingresado no existe", HttpStatus.NOT_FOUND);
        }
        this.cardService.insertCustomerCard(card);
        return new ResponseEntity<>("Se ingresó la tarjeta correctamente", HttpStatus.OK);
    }

    @Autowired
    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
