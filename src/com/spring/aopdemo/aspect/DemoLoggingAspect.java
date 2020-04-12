package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    // add all our related advices for logging

    // start with @Before advice testing

    @Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

//    @Before("execution(public void add*())")
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("========= API ANALYTICS =========");
    }
}
