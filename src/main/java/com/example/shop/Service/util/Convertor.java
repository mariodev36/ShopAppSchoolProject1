package com.example.shop.Service.util;

import com.example.shop.DTO.DtoCutomer.CustomerRequestDto;
import com.example.shop.DTO.DtoCutomer.CustomerResponseDto;
import com.example.shop.DTO.PurchaseDto.PurchaseResponseDto;
import com.example.shop.Entity.Customer;
import com.example.shop.Entity.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Convertor {



        public static PurchaseResponseDto toResponseDTO (Purchase purchase){
        return PurchaseResponseDto.builder()
                .id(purchase.getId())
                .build();

    }




            public Customer fromDto(CustomerRequestDto request) {
                return Customer.builder()
                        .customerEmail(request.getEmail())
                        .password(request.getPassword())
                        .build();
            }

            public CustomerResponseDto toDto(Customer customer) {


                return CustomerResponseDto.builder()
                        .customerId(customer.getId())
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .email(customer.getCustomerEmail())
                        .purchases(fromPurchase(customer.getPurchases()))
                        .build();
            }
    List<PurchaseResponseDto> fromPurchase(List<Purchase> purhcases) {
        return purhcases.stream()
                .map(purhcase -> toResponseDTO(purhcase) )
                .toList();
    }

    public List<CustomerResponseDto> fromCustomers(List<Customer> customers){
        return customers.stream()
                .map(customer -> toDto(customer))
                .toList();
    }

    }

