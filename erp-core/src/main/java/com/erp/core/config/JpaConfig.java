package com.erp.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // This is the "engine" that makes BaseEntity work
public class JpaConfig {
}