package com.panel.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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

    @Column(name = "username")
    @NotEmpty
    private String username;

    @Column(name = "email")
    @NotEmpty
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @Column(name = "password")
    @NotEmpty
    private String password;


    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CreditCard cardInfo;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private BillAddress billingAddress;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private ShipAddress shippingAddress;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Customer(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


}
