package com.ecommerce.GPDemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "roles")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "role")
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany(mappedBy = "userRoleList")
    private List<User> users;

    public UserRole(Role role) {
        this.role = role;
    }
}
