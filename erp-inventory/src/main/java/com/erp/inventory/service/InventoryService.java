package com.erp.inventory.service;

import com.erp.inventory.model.Product;
import com.erp.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product addStock(Long productId, Integer quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setStockQuantity(product.getStockQuantity() + quantity);
        return productRepository.save(product);
    }
}