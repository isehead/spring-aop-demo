package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ApiAnalyticsAspect {

    @Before("com.spring.aopdemo.aspect.AopExpressions.forDaoNoGettersNoSetters()")
    public void performApiAnalytics() {
        System.out.println("========= API ANALYTICS =========");
    }
}
