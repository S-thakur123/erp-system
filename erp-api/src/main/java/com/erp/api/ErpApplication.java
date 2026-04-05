package com.erp.api;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.erp")
@EnableJpaRepositories(basePackages = "com.erp") // Scan all modules for Repositories
@EntityScan(basePackages = "com.erp")           // Scan all modules for Entities
public class ErpApplication {

    public static void main(String[] args) {

        System.setProperty("user.timezone", "UTC");

        SpringApplication.run(ErpApplication.class, args);
    }
}