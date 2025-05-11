package com.example.shop.DTO.DtoCutomer;

import com.example.shop.DTO.PurchaseDto.PurchaseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponseDto {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private List<PurchaseResponseDto> purchases;




}
