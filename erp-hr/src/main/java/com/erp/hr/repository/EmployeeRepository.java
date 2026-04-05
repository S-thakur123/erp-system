package com.erp.hr.repository;

import com.erp.hr.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom search required for "Advanced Search" requirement
    List<Employee> findByDepartmentIgnoreCase(String department);
    List<Employee> findByEmailContaining(String email);
}