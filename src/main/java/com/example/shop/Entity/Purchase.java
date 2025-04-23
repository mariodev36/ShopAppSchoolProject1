package com.example.shop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
PurchaseStatus status;
}
