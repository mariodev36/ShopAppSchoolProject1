package com.example.shop.Service;

import com.example.shop.Entity.ConfirmationCode;
import com.example.shop.Entity.Customer;
import com.example.shop.Repository.ConfirmationCodeRepository;
import com.example.shop.Service.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ConfirmationService {

    private final ConfirmationCodeRepository repository;

    private final int EXPIRATION_PERIOD = 1;

    private final String LINK_PATH = "localhost:8080/api/public/confirmation?code=";


    private String generateCode(){
        String code = UUID.randomUUID().toString();
        return code;
    }

    private void saveConfirmationCode(String code, Customer customer){
        ConfirmationCode newCode = new ConfirmationCode();
        newCode.setCode(code);
        newCode.setCustomer(customer);
        repository.save(newCode);
    }

    public void sendCodeByEmail(String code, String userEmail){
        String message = LINK_PATH + code;
        // тут будет отправка пользователю письма с кодом подтверждения
    }

    public void confirmationCodeHandle(Customer customer){
        String code = generateCode();
        saveConfirmationCode(code, customer);
        sendCodeByEmail(code, customer.getCustomerEmail());
    }

    public Customer confirmUserByCode(String code){
        ConfirmationCode confirmationCode = repository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("Confirmation code : " + code + " not found"));


        Customer user = confirmationCode.getCustomer();
        confirmationCode.setConfirmed(true);
        repository.save(confirmationCode);

        return user;
    }

}
