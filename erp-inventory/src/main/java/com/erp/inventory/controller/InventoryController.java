package com.erp.inventory.controller;

import com.erp.inventory.model.Product;
import com.erp.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.erp.security.annotation.AuditLog;

@RestController
@RequestMapping("/api/inventory") // Make sure this matches your Postman URL
public class InventoryController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products") // Final path: /api/inventory/products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
    @AuditLog(action = "CREATE_PRODUCT")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}