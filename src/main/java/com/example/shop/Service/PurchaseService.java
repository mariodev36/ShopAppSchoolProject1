package com.example.shop.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseService {

//    private PurchaseRepo repository;
//    private CustomerService service;
//    private Convertor convertor;
//
//    public PurchaseResponseDto createTask(PurchaseRequestDto request){
//
//        Optional<Customer> customerOptional = service.findCustomerByEmailForCreatedPurchase(request.getCustomerEmail());
//
//        Purchase newPurchase = convertor.fromDto(request);
//        LocalDateTime now = LocalDateTime.now();
//        newPurchase.setStatus(Purchase.PurchaseStatus.PENDING);
//
//        newPurchase.setCustomer(customerOptional.get());
//
//        Purchase savedPurchase = repository.save(newPurchase);
//
//        PurchaseResponseDto response = convertor.toDto(savedPurchase);
//
//        return response;
//
//    }
//
//    public List<PurchaseResponseDto> findAll(){
//        return repository.findAll().stream()
//                .map(purchase -> convertor.toDto(purchase))
//                .toList();
//    }
//
//    public Purchase findPurchaseById(Integer id){
//        Optional<Purchase> optionalTask = repository.findById(id);
//
//        if (optionalTask.isPresent()) {
//            return optionalTask.get();
//        } else {
//            throw new NotFoundException("Purchase with ID = " + id + " not found");
//        }
//
//
//    }

}
