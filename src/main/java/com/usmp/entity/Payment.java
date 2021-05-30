package com.usmp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "pago")
public class Payment {

    @Id
    @Column(name = "codigo")
    private String paymentNumber;

    @OneToOne
    @JoinColumn(name = "numero_tarjeta")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Customer customer;

    @Column(name = "fecha_pago")
    @NotNull
    private Date paymentDate;

    @Column(name = "monto")
    @NotNull
    private Double amount;

    public String getPaymentNumber() { return paymentNumber; }
    public void setPaymentNumber(String paymentNumber) { this.paymentNumber = paymentNumber; }
    public Card getCard() { return card; }
    public void setCard(Card card) { this.card = card; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    public Date getPaymentDate() { return paymentDate; }
    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Payment{");
        sb.append("paymentNumber='").append(paymentNumber).append('\'');
        sb.append(", card=").append(card);
        sb.append(", customer=").append(customer);
        sb.append(", paymentDate=").append(paymentDate);
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }

}
