package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

    //    @Before("execution(public void add*())")
    @Before("com.spring.aopdemo.aspect.AopExpressions.forDaoNoGettersNoSetters()")
    public void beforeAddAccountAdvice() {
        System.out.println("=====>>> Executing @Before advice on addAccount()");
    }

}
