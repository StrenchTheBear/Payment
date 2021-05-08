package com.usmp.entity;

public class Card {

    private Integer id;
    private String cardNumber;
    private String cardName;
    private String cardSecurityCode;
    private String maturyDate;
    private String cardType;
    private Integer customerId;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getCardNumber() { return cardNumber; }

    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getCardName() { return cardName; }

    public void setCardName(String cardName) { this.cardName = cardName; }

    public String getCardSecurityCode() { return cardSecurityCode; }

    public void setCardSecurityCode(String cardSecurityCode) { this.cardSecurityCode = cardSecurityCode; }

    public String getMaturyDate() { return maturyDate; }

    public void setMaturyDate(String maturyDate) { this.maturyDate = maturyDate; }

    public String getCardType() { return cardType; }

    public void setCardType(String cardType) { this.cardType = cardType; }

    public Integer getCustomerId() { return customerId; }

    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("id=").append(id);
        sb.append(", cardNumber='").append(cardNumber).append('\'');
        sb.append(", cardName='").append(cardName).append('\'');
        sb.append(", cardSecurityCode='").append(cardSecurityCode).append('\'');
        sb.append(", maturyDate='").append(maturyDate).append('\'');
        sb.append(", cardType='").append(cardType).append('\'');
        sb.append(", customerId=").append(customerId);
        sb.append('}');
        return sb.toString();
    }

}
