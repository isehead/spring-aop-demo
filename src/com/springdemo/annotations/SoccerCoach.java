/*
package com.springdemo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class SoccerCoach implements Coach {

    @Autowired
    @Qualifier("fileFortuneService")
    private FileFortuneService fileFortuneService;


    @Autowired
    public SoccerCoach() {
        System.out.println("SoccerCoach - inside the default constructor");
    }

    @Override
    public String getDailyWorkout() {
        return ("Strike 25 kicks on target");
    }

    @Override
    public String getDailyFortune() {
        return fileFortuneService.getFortune();
    }

}
*/
