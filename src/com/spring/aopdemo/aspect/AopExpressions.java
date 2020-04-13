package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    // pointcut for getters
    @Pointcut("execution(* com.spring.aopdemo.dao.*.get*(..))")
    public void getter() {
    }

    // pointcut for setters
    @Pointcut("execution(* com.spring.aopdemo.dao.*.set*(..))")
    public void setter() {
    }

    // pointcut for the package - include everything except getters and setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoNoGettersNoSetters() {
    }

    @Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

}
