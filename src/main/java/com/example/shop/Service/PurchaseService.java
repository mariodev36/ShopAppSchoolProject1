package com.example.shop.Service;

import com.example.shop.DTO.PurchaseRequestDto;
import com.example.shop.DTO.PurchaseResponseDto;
import com.example.shop.Entity.Customer;
import com.example.shop.Entity.Purchase;
import com.example.shop.Entity.PurchaseStatus;
import com.example.shop.Repository.PurchaseRepo;
import com.example.shop.Service.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PurchaseService {

    private PurchaseRepo repository;
    private CustomerService service;
    private Convertor convertor;

    public PurchaseResponseDto createTask(PurchaseRequestDto request){

        Optional<Customer> customerOptional = service.findCustomerByEmailForCreatedPurchase(request.getCustomerEmail());

        Purchase newPurchase = convertor.fromDto(request);
        LocalDateTime now = LocalDateTime.now();
        newPurchase.setStatus(PurchaseStatus.PENDING);

        newPurchase.setCustomer(customerOptional.get());

        Purchase savedPurchase = repository.save(newPurchase);

        PurchaseResponseDto response = convertor.toDto(savedPurchase);

        return response;

    }

    public List<PurchaseResponseDto> findAll(){
        return repository.findAll().stream()
                .map(purchase -> convertor.toDto(purchase))
                .toList();
    }

    public Purchase findPurchaseById(Integer id){
        Optional<Purchase> optionalTask = repository.findById(id);

        if (optionalTask.isPresent()) {
            return optionalTask.get();
        } else {
            throw new NotFoundException("Purchase with ID = " + id + " not found");
        }


    }

}
