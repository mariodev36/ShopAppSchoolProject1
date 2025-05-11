package com.example.shop.Service;

import com.example.shop.DTO.DtoCutomer.CustomerRequestDto;
import com.example.shop.DTO.DtoCutomer.CustomerResponseDto;
import com.example.shop.Entity.Customer;
import com.example.shop.Repository.CustomerRepository;
import com.example.shop.Service.exceptions.AlreadyExistException;
import com.example.shop.Service.exceptions.NotFoundException;
import com.example.shop.Service.util.Convertor;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

 private final CustomerRepository repository;
private final Convertor converter;
 private final ConfirmationService confirmationCodeService;

 @Transactional
 public CustomerResponseDto registration(CustomerRequestDto request){
  if (repository.existsByCustomerEmail(request.getEmail())) {
   throw new AlreadyExistException("User with email: " + request.getEmail() + " is already exist");
  }

  Customer newUser = converter.fromDto(request);
  repository.save(newUser);

  confirmationCodeService.confirmationCodeHandle(newUser);

  return converter.toDto(newUser);

 }

 public List<CustomerResponseDto> findAllCustomers(){
  List<Customer> customers= repository.findAll();
  List<CustomerResponseDto> responses = converter.fromCustomers(customers);

  return responses;
 }

 public CustomerResponseDto findUserById(Integer id){
  Customer customer = repository.findById(id)
          .orElseThrow(() -> new NotFoundException("User with ID = " + id + " not found"));

  return converter.toDto(customer);
 }

 public List<Customer> findFullDetailUsers(){
  return repository.findAll();
 }

 public CustomerResponseDto findUserByEmail(String email){
  Customer customer = repository.findByCustomerEmail(email)
          .orElseThrow(() -> new NotFoundException("User with email: " + email + " not found"));

  return converter.toDto(customer);
 }


 @Transactional
 public CustomerResponseDto confirmationEmail(String code){

  Customer customer = confirmationCodeService.confirmUserByCode(code);


  repository.save(customer);

  return converter.toDto(customer)  ;
 }


}
