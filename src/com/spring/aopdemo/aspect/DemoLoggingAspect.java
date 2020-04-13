package com.spring.aopdemo.aspect;

import com.spring.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

    //    @Before("execution(public void add*())")
    @Before("com.spring.aopdemo.aspect.AopExpressions.forDaoNoGettersNoSetters()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("=====>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method signature is: " + methodSignature);

        //display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args){

            if(tempArg instanceof Account){
                // downcast and print Account-specific stuff
                Account account = (Account) tempArg;
                System.out.println(account);
            }
        }
    }


}
