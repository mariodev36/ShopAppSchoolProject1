package com.example.shop.DTO.DtoCutomer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequestDto {

    private String email;
    private String password;

}
