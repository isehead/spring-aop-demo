package com.spring.aopdemo;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        // read the spring config class
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        MembershipDAO membershipDAO = applicationContext.getBean("membershipDAO", MembershipDAO.class);
        AccountDAO accountDAO = applicationContext.getBean("accountDAO", AccountDAO.class);

        // call the business method
        System.out.println("Call new account/add account/membershipDAO addMember");
        Account account = new Account();
        account.setName("John");
        account.setLevel("Connor");
        System.out.println("Before accountDAO.addAccount");
        accountDAO.addAccount(account,false);
        membershipDAO.addMember();

        // call the accountDAO getters and setters
        System.out.println("Call the accountDAO getters and setters");
        accountDAO.setName("testName");
        accountDAO.setServiceCode("123");
        accountDAO.getName();
        accountDAO.getServiceCode();

        // call the business method again
        System.out.println("\nCalling an aspect again");
        accountDAO.addAccount(account,true);
        membershipDAO.addMember();
        accountDAO.doSmth();

        // close the context
        applicationContext.close();

    }
}
