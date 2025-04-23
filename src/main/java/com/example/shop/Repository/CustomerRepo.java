package com.example.shop.Repository;

import com.example.shop.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByCustomerEmail(String managerEmail);
}
