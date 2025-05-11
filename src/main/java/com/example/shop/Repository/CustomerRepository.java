package com.example.shop.Repository;

import com.example.shop.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

   boolean existsByCustomerEmail(String customerEmail);
   Optional<Customer> findByCustomerEmail(String customerEmail);


}
