package com.erp.reporting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardStats {
    private long totalProducts;
    private long lowStockCount;
    private double totalRevenue;
}