package com.example.shop.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String customerName;
    private String customerEmail;
    private  String password;

    @OneToMany
            @JoinColumn( name = "purchase_id")
    List<Purchase> purchases;
}
