package com.example.shop.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @NotBlank(message = "First name is required and must be not blank")
    @Size(min = 3, max = 15, message = "First name length not correct")
    private String firstName;

    private String lastName;
    @Email
    @Column(nullable = false, unique = true)
    private String customerEmail;

    private  String password;

    @OneToMany(mappedBy = "purchase_id", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Purchase> purchases;
}
