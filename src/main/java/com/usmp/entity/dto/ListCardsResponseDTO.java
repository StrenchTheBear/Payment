package com.usmp.entity.dto;

import java.util.List;

public class ListCardsResponseDTO {

    private CustomerDTO customer;
    private List<CardInfoDTO> cards;

    public CustomerDTO getCustomer() { return customer; }
    public void setCustomer(CustomerDTO customer) { this.customer = customer; }
    public List<CardInfoDTO> getCards() { return cards; }
    public void setCards(List<CardInfoDTO> cards) { this.cards = cards; }

}
