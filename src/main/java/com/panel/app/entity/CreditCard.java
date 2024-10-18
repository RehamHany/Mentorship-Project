package com.panel.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "card_info")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiry_date")
    private String expiryDate;  // Format: MM/YYYY

    @Column(name = "cvv")
    private Integer cvv;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public CreditCard(String cardNumber, String expiryDate, Integer cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }
}
