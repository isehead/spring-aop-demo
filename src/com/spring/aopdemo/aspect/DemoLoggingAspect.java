package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    // add all our related advices for logging

    // start with @Before advice testing

//    @Before("execution(public void add*())")

    @Before("execution(* com.spring.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}
