package com.usmp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tarjeta")
public class Card {

    @Id
    @Column(name = "numero_tarjeta")
    private String cardNumber;
    @Column(name = "nombre")
    private String name;
    @Column(name = "fecha_registro")
    private Date registrationDate;
    @Column(name = "fecha_expiracion")
    private String expirationDate;
    @Column(name = "codigo_cvc")
    private Integer cvcCode;
    @Column(name = "saldo")
    private BigDecimal balance;
    @Column(name = "numero_cuenta")
    private String accountNumber;
    @Column(name = "codigo_interbancario")
    private String interbankCode;

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(Date registrationDate) { this.registrationDate = registrationDate; }
    public String getExpirationDate() { return expirationDate; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }
    public Integer getCvcCode() { return cvcCode; }
    public void setCvcCode(Integer cvcCode) { this.cvcCode = cvcCode; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public String getInterbankCode() { return interbankCode; }
    public void setInterbankCode(String interbankCode) { this.interbankCode = interbankCode; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("cardNumber='").append(cardNumber).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", registrationDate=").append(registrationDate);
        sb.append(", expirationDate='").append(expirationDate).append('\'');
        sb.append(", cvcCode=").append(cvcCode);
        sb.append(", balance=").append(balance);
        sb.append(", accountNumber='").append(accountNumber).append('\'');
        sb.append(", interbankCode='").append(interbankCode).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
