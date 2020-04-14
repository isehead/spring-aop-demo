package com.spring.aopdemo.aspect;

import com.spring.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.spring.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // print the method we advise on
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("Executing @Around on method: " + method);

        // begin timestamp
        long beginCount = System.currentTimeMillis();

        // execute the method
        Object result = proceedingJoinPoint.proceed();

        // get the second timestamp
        long endCount = System.currentTimeMillis();

        // calculate duration
        long duration = endCount - beginCount;
        logger.info("Duration is: " + duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        // print the method we advise on
        String method = joinPoint.getSignature().toShortString();
        logger.info("Executing @AfterFINALLY on method: " + method);
    }

    @AfterThrowing(pointcut = "execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {

        // print the method we advise on
        String method = joinPoint.getSignature().toShortString();
        logger.info("Executing @AfterThrowing on method: " + method);

        // log the exception
        logger.info("The exception is: " + theExc);
    }

    // add a new advice for @AfterReturning on the findAccounts() method
    @AfterReturning(pointcut = "execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        logger.info("Result is: " + result);

        // post-process and modify the data
        convertToUpperCase(result);
        logger.info("Result is: " + result);
    }

    private void convertToUpperCase(List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

    //    @Before("execution(public void add*())")
    @Before("com.spring.aopdemo.aspect.AopExpressions.forDaoNoGettersNoSetters()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        logger.info("=====>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method signature is: " + methodSignature);

        //display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args) {

            if (tempArg instanceof Account) {
                // downcast and print Account-specific stuff
                Account account = (Account) tempArg;
                logger.info(account.toString());
            }
        }
    }


}
