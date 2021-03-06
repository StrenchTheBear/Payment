package com.usmp.entity.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterCardRequestDTO {

    @NotNull
    private String cardName;

    @NotNull
    @Size(min = 16, max = 16, message = "debe tener una longitud de 16 caracteres exactamente")
    private String cardNumber;

    @NotNull
    private String expirationDate;

    @NotNull
    private Integer customerId;

    public String getCardName() { return cardName; }
    public void setCardName(String cardName) { this.cardName = cardName; }
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public String getExpirationDate() { return expirationDate; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }
    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

}
