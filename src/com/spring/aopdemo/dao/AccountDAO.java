package com.spring.aopdemo.dao;

import com.spring.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

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
