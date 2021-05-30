package com.usmp.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class PaymentDTO {

    @NotNull
    private String cardName;

    @NotNull
    @Size(min = 16, max = 16, message = "debe tener una longitud de 16 caracteres exactamente")
    private String cardNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "##/##")
    @NotNull
    private String expirationDate;

    @NotNull
    private Integer cvcCode;

    @NotNull
    private Integer customerId;

    @NotNull
    @Size(min = 8, max = 8, message = "debe tener una longitud de 8 caracteres exactamente")
    private String documentNumber;

    @NotNull
    private BigDecimal amount;

    public String getCardName() { return cardName; }
    public void setCardName(String cardName) { this.cardName = cardName; }
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public String getExpirationDate() { return expirationDate; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }
    public Integer getCvcCode() { return cvcCode; }
    public void setCvcCode(Integer cvcCode) { this.cvcCode = cvcCode; }
    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }
    public String getDocumentNumber() { return documentNumber; }
    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

}
