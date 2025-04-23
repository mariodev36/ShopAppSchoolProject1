package com.example.shop.Service;

import com.example.shop.DTO.DtoCutomer.CustomerRequestDto;
import com.example.shop.DTO.DtoCutomer.CustomerResponseDto;
import com.example.shop.Entity.Customer;
import com.example.shop.Repository.CustomerRepo;
import com.example.shop.Service.exceptions.AlreadyExistCustomerException;
import com.example.shop.Service.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
 private CustomerRepo repository;
private Convertor convertor;

public CustomerResponseDto createCustomer(CustomerRequestDto request) {
    if (isExistCustomer(request.getCustomerEmail())){
        throw new AlreadyExistCustomerException("User with this  email  " + request.getCustomerEmail() + " exist");
    }

Customer newCustomer = convertor.customerFromDto(request);
Customer savedCustomer = repository.save(newCustomer);
CustomerResponseDto responseDto = convertor.dtoFromCustomer(savedCustomer);
return responseDto;
}

    private boolean isExistCustomer(String email) {
        Optional<Customer> existCustomer = repository.findByCustomerEmail(email);
        return existCustomer.isPresent();

    }

    public List<CustomerResponseDto> findAllCustomers(){
        return repository.findAll().stream()
                .map(customer -> convertor.dtoFromCustomer(customer))
                .toList();
    }

    public CustomerResponseDto findCustomerByEmail(String email){

        Optional<Customer> customerOptional = repository.findByCustomerEmail(email);

        if (customerOptional.isPresent()) {
            CustomerResponseDto response = convertor.dtoFromCustomer(customerOptional.get());
            return response;
        } else {
            throw new NotFoundException("User with email " + email + " not found");
        }

    }

    public Optional<Customer> findCustomerByEmailForCreatedPurchase(String email){

        return repository.findByCustomerEmail(email);


    }


}
