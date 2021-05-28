package com.usmp.entity.dto;

public class CardInfoDTO {

    private String cardName;
    private String cardNumber;

    public String getCardName() { return cardName; }
    public void setCardName(String cardName) { this.cardName = cardName; }
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public CardInfoDTO() {
    }

    public CardInfoDTO(String cardName, String cardNumber) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
    }
}
