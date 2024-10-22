package com.panel.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;

@Entity
@Table(name = "cart")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Value("${shipping.cost}")
    @Column(name = "shipping_cost")
    private Long shippingCost;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Cart(User user) {
        this.user=user;
    }
}
