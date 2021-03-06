package com.spring.aopdemo;

import com.spring.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {
        // read the spring config class
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = applicationContext.getBean("accountDAO", AccountDAO.class);

        List<Account> accountList = accountDAO.findAccounts(false);
        System.out.println("\nMain program: AfterReturning");
        System.out.println("========================");
        System.out.println(accountList);
        System.out.println("-------------");

        // close the context
        applicationContext.close();

    }
}
