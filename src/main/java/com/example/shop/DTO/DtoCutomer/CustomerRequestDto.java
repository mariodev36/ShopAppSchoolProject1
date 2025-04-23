package com.example.shop.DTO.DtoCutomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

    private String customerName;
    private String customerEmail;
    private String password;

}
