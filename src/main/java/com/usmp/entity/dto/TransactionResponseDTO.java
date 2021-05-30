package com.usmp.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TransactionResponseDTO {

    private String paymentNumber;
    private Date paymentDate;
    private Double amount;

    public String getPaymentNumber() { return paymentNumber; }
    public void setPaymentNumber(String paymentNumber) { this.paymentNumber = paymentNumber; }
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    public Date getPaymentDate() { return paymentDate; }
    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public TransactionResponseDTO() {
    }

    public TransactionResponseDTO(String paymentNumber, Date paymentDate, Double amount) {
        this.paymentNumber = paymentNumber;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

}
