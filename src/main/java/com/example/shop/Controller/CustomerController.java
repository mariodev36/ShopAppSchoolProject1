package com.example.shop.Controller;

import com.example.shop.DTO.DtoCutomer.CustomerRequestDto;
import com.example.shop.DTO.DtoCutomer.CustomerResponseDto;
import com.example.shop.Entity.Customer;
import com.example.shop.Service.CustomerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }


    @PostMapping()
    public CustomerResponseDto createNewCustomer(@Valid @RequestBody CustomerRequestDto request) {
        return service.createCustomer(request);
    }

    @GetMapping()
    public List<CustomerResponseDto> findAll() {
        return service.findAllCustomers();
    }

    @GetMapping("/email")
    // /api/managers/email?managerEmail=manager1@company.com
    public CustomerResponseDto findByEmail(@RequestParam String managerEmail) {
        return service.findCustomerByEmail(managerEmail);


    }
}


//    @GetMapping("/{id}")
//    public Customer findById(@PathVariable Integer id){
//        return service.find(id);
//}
