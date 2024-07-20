package com.example.SpringAOP;

import com.example.SpringAOP.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private BankService bankService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(bankService.getAccountBalance("12345"));
        System.out.println(bankService.transferFunds("12345", "67890", 500.0));
        try {
            bankService.throwError();
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
