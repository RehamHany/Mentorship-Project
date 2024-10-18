package com.panel.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "billing_address")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class BillAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "addressL1")
    private String addressL1;

    @Column(name = "addressL2")
    private String addressL2;

    @Column(name = "postal_code")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public BillAddress(String addressL1, String addressL2, String postalCode) {
        this.addressL1 = addressL1;
        this.addressL2 = addressL2;
        this.postalCode = postalCode;
    }
}
