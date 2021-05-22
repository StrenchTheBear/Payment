package com.usmp.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "tarjeta_cliente")
public class CustomerCard {

    @Id
    @Column(name = "numero_tarjeta")
    private String cardNumber;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Customer customer;

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomerCards{");
        sb.append("cardNumber='").append(cardNumber).append('\'');
        sb.append(", customer=").append(customer);
        sb.append('}');
        return sb.toString();
    }

}
