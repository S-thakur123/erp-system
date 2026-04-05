package com.erp.reporting.service;

import com.erp.inventory.repository.ProductRepository;
import com.erp.accounting.repository.TransactionRepository;
import com.erp.sales.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository;
    public Map<String, Object> getExecutiveSummary() {
        Map<String, Object> report = new HashMap<>();
        report.put("totalProducts", productRepository.count());
        report.put("totalTransactions", transactionRepository.count());
        report.put("totalCustomers", customerRepository.count());
        return report;
    }
}