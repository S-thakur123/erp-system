package com.erp.hr.controller;

import com.erp.hr.model.Employee;
import com.erp.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hr")
public class HRController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    @PreAuthorize("hasRole('HR_ADMIN')") // RBAC Requirement
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> listEmployees() {
        return employeeService.getAllEmployees();
    }
}