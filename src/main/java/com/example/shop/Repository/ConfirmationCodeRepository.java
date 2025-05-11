package com.example.shop.Repository;

import com.example.shop.Entity.ConfirmationCode;
import com.example.shop.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ConfirmationCodeRepository extends JpaRepository<ConfirmationCode, Integer> {

    Optional<ConfirmationCode> findByCode(String code);

    Optional<ConfirmationCode> findByCodeAndExpireDataTimeAfter(String code, LocalDateTime currentDataTime);

    List<ConfirmationCode> findByCustomer(Customer customer);
}

