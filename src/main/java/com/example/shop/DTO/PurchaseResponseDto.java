package com.example.shop.DTO;

import com.example.shop.DTO.DtoCutomer.CustomerResponseDto;
import com.example.shop.Entity.PurchaseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PurchaseResponseDto {
    private Integer id;
    private PurchaseStatus status;
    CustomerResponseDto customer;
}
