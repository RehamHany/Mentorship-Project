package com.panel.app.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name = "customers")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CreditCard cardInfo;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private BillAddress billingAddress;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private ShipAddress shippingAddress;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;




}
