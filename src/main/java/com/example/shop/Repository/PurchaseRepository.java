package com.example.shop.Repository;

import com.example.shop.Entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PurchaseRepository extends JpaRepository<com.example.shop.Entity.Purchase, Integer> {

    boolean existsPurchaseByPurchaseId(Integer id);
    Optional<Purchase>findPurchaseById(Integer id);

}
