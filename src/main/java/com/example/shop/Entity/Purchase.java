package com.example.shop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Purchase {

    public enum PurchaseStatus {
        PENDING,
        APPROVED,
        REJECTED,

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private LocalDateTime purchaseDate;
        //@ManyToMany
        // Lis<Product> products
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
PurchaseStatus status;
}


