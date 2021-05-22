package com.usmp.entity.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CardRequest {

    @NotNull
    @Size(min = 16, max = 16, message = "debe tener una longitud de 16 caracteres exactamente")
    private String cardNumber;

    @NotNull
    private String expirationDate;

    @NotNull
    @Size(min = 3, max = 3, message = "debe tener una longitud de 3 caracteres exactamente")
    private String cvcCode;

    @NotNull
    private Integer customerId;

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public String getExpirationDate() { return expirationDate; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }
    public String getCvcCode() { return cvcCode; }
    public void setCvcCode(String cvcCode) { this.cvcCode = cvcCode; }
    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

}
