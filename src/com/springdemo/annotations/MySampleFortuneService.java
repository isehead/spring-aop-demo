package com.springdemo.annotations;

import org.springframework.stereotype.Component;

@Component
public class MySampleFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return null;
    }
}
