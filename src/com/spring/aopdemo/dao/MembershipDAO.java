package com.spring.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addMember(){
        System.out.println("MembershipDAO's add method");
        return false;
    }
}
