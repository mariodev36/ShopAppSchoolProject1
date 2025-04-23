package com.example.shop.Service;

import com.example.shop.DTO.DtoCutomer.CustomerRequestDto;
import com.example.shop.DTO.DtoCutomer.CustomerResponseDto;
import com.example.shop.DTO.PurchaseRequestDto;
import com.example.shop.DTO.PurchaseResponseDto;
import com.example.shop.Entity.Customer;
import com.example.shop.Entity.Purchase;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;


@Component
public class Convertor {

    public Purchase fromDto(PurchaseRequestDto dto) {
        Purchase purchase = new Purchase();
        purchase.setId(dto.getId());
        return purchase;
    }

    public PurchaseResponseDto toDto(Purchase purchase) {

        PurchaseResponseDto dto = new PurchaseResponseDto();

        dto.setId(purchase.getId());
        dto.setStatus(purchase.getStatus());

        ////////////////////////


        Customer customerFromPurchase = purchase.getCustomer();

        CustomerResponseDto customerResponseDto = dtoFromCustomer(customerFromPurchase);


        dto.setCustomer(customerResponseDto);

        return dto;
    }


    public CustomerResponseDto dtoFromCustomer(Customer customer) {
        CustomerResponseDto customerResponseDto = new CustomerResponseDto(
                customer.getId(),
                customer.getCustomerName(),
                customer.getCustomerEmail()
        );

        return customerResponseDto;
    }


    public Customer customerFromDto(CustomerRequestDto dto) {
        Customer customer = new Customer();

        customer.setCustomerName(dto.getCustomerName());
        customer.setCustomerEmail(dto.getCustomerEmail());
        customer.setPassword(dto.getPassword());

        return customer;

    }

}
