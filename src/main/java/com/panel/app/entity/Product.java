package com.panel.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "products")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "image")
    @NotEmpty
    private String image;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "unit")
    @NotEmpty
    private String unit;

    @Column(name = "price")
    @NotEmpty
    private double price;

    @Column(name = "description")
    @NotEmpty
    private String description;

    @ManyToMany(mappedBy = "products", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<User> users;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private CartItem cart;

    public Product(String image, String name, String unit, double price, String description) {
        this.image = image;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.description = description;
    }
}
