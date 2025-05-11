package com.example.shop.DTO.PurchaseDto;

import com.example.shop.DTO.DtoCutomer.CustomerResponseDto;
import com.example.shop.Entity.Purchase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PurchaseResponseDto {
    private Long id;
private LocalDateTime purchaseDate;

}
