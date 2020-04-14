package com.spring.aopdemo;

import com.spring.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {
        // read the spring config class
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = applicationContext.getBean("accountDAO", AccountDAO.class);

        List<Account> accountList = null;
        try{
            // add a flag to simulate exception
            boolean tripWire = true;
            accountList = accountDAO.findAccounts(tripWire);
        }catch (Exception e){
            System.out.println("Exception: " + e);
        }

        System.out.println("\nMain program: AfterThrowing");
        System.out.println("========================");
        System.out.println(accountList);
        System.out.println("-------------");

        // close the context
        applicationContext.close();

    }
}
