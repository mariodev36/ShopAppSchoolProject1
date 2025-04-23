package com.example.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepo extends JpaRepository<com.example.shop.Entity.Purchase, Integer> {
}
