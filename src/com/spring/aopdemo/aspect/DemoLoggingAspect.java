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

    // pointcut for getters
    @Pointcut("execution(* com.spring.aopdemo.dao.*.get*(..))")
    private void getter() {
    }

    // pointcut for setters
    @Pointcut("execution(* com.spring.aopdemo.dao.*.set*(..))")
    private void setter() {
    }

    // pointcut for the package - include everything except getters and setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoNoGettersNoSetters() {
    }

    @Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    //    @Before("execution(public void add*())")
    @Before("forDaoNoGettersNoSetters()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoNoGettersNoSetters()")
    public void performApiAnalytics() {
        System.out.println("========= API ANALYTICS =========");
    }
}
