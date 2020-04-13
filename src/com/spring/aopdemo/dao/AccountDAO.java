package com.spring.aopdemo.dao;

import com.spring.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public List<Account> findAccounts() {
        List<Account> accountList = new ArrayList<>();

        Account account1 = new Account("Steven", "Gerrard");
        Account account2 = new Account("Leroy", "Jenkins");
        Account account3 = new Account("John", "Terry");
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        return accountList;
    }

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": ADDING AN ACCOUNT\n");
    }

    public void doSmth(){
        System.out.println("AccountDAO do something method");
    }

    public String getName() {
        System.out.println("GETTER name test message");
        return name;
    }

    public void setName(String name) {
        System.out.println("SETTER name test message");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("GETTER serviceCode test message");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("SETTER serviceCode test message");
        this.serviceCode = serviceCode;
    }
}
