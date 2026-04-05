package com.erp.inventory.model;

import com.erp.core.model.BaseEntity;
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "products")
@Data
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    private String name;

    private String sku;

    @Min(value = 0, message = "Stock cannot be negative")
    private Integer stockQuantity;

    private Double price;
}