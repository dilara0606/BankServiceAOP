package com.example.SpringAOP.service;

import org.springframework.stereotype.Service;

@Service
public class BankService {

    public String transferFunds(String accountFrom, String accountTo, double amount) {
        // Transfer işlemi
        return "Transferred " + amount + " from " + accountFrom + " to " + accountTo;
    }

    public String getAccountBalance(String account) {
        // Bakiye sorgulama işlemi
        return "Balance for account " + account + " is 1000.0";
    }

    public String throwError() {
        throw new RuntimeException("This is an error");
    }
}
