package com.erp.security.aspect;

import com.erp.security.annotation.AuditLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    @AfterReturning(pointcut = "@annotation(auditLog)", returning = "result")
    public void logAction(JoinPoint joinPoint, AuditLog auditLog, Object result) {
        System.out.println("AUDIT LOG [" + auditLog.action() + "]: Action performed successfully.");
        // In a real system, you'd save this to a 'audit_logs' table
    }
}