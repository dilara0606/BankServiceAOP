package com.example.SpringAOP.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BankingAspect {

    @Before("execution(* com.example.SpringAOP.service.*.*(..))")
    public void authenticateUser() {
        // Kullanıcının doğrulanıp doğrulanmadığını kontrol edin
        if (!isUserAuthenticated()) {
            throw new SecurityException("User is not authenticated");
        }
    }

    private boolean isUserAuthenticated() {
        // Burada kullanıcı doğrulama mantığını uygulayın
        return true; // Bu örnek için her zaman true döndürüyoruz
    }

    @Around("execution(* com.example.SpringAOP.service.*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

    @AfterThrowing(pointcut = "execution(* com.example.SpringAOP.service.*.*(..))", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("Exception: " + exception.getMessage());
    }
}
