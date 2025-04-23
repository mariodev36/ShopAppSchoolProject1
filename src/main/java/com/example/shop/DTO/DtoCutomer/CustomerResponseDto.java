package com.example.shop.DTO.DtoCutomer;

import com.example.shop.DTO.PurchaseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {
    private Integer customerId;
    private String customerName;
    private String customerEmail;




}
