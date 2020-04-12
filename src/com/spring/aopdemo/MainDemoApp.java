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
        Account account = new Account();
        accountDAO.addAccount(account,false);
        membershipDAO.addMember();

        // call the business method again
        System.out.println("\nCalling an aspect again\n");
        accountDAO.addAccount(account,true);
        membershipDAO.addMember();
        accountDAO.doSmth();

        // close the context
        applicationContext.close();

    }
}
