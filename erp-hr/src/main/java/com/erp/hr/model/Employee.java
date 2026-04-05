package com.erp.hr.model;

import com.erp.core.model.BaseEntity; // Importing from your erp-core!
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employees")
@Data
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @NotBlank(message = "Employee email is required")
    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String email;

    private String department;
    private Double salary;
}