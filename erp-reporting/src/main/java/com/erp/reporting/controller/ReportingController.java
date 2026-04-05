package com.erp.reporting.controller;

import com.erp.reporting.dto.DashboardStats;
import com.erp.reporting.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportingController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/dashboard")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public Map<String, Object> getDashboard() {
        // Fetches cross-module analytics for the executive summary
        return reportService.getExecutiveSummary();
    }
}