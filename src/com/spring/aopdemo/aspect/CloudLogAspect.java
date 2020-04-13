package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class CloudLogAspect {

    @Before("com.spring.aopdemo.aspect.AopExpressions.forDaoNoGettersNoSetters()")
    public void logToCloudAsync() {
        System.out.println("========= LOGGING TO CLOUD =========");
    }
}
