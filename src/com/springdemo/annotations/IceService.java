package com.springdemo.annotations;

public class IceService implements FortuneService {

    @Override
    public String getFortune() {
        return ("This is hockey fortune");
    }

}
