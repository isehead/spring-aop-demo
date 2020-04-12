package com.spring.aopdemo.dao;

import com.spring.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": ADDING AN ACCOUNT\n");
    }

    public void doSmth(){
        System.out.println("Do something method");
    }
}
