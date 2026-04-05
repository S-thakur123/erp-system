package com.erp.accounting.controller;

import com.erp.accounting.model.Transaction;
import com.erp.accounting.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounting")
//@PreAuthorize("hasRole('FINANCE_ADMIN')")
public class AccountingController {

    @Autowired
    private TransactionRepository repository;

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }
}