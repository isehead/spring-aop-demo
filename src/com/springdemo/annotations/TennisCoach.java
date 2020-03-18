package com.springdemo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach(){
        System.out.println("TennisCoach - inside the default constructor");
    };

    // define init-method
    @PostConstruct
    public void doStartup(){
        System.out.println("Doing startup stuff");
    }

    // define destroy-method
    @PreDestroy
    public void doCleanup(){
        System.out.println("Doing cleanup stuff");
    }


/*    @Autowired
    public TennisCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }*/

/*    @Autowired
    public void doSomeStuff(FortuneService fortuneService) {
        System.out.println("TennisCoach - inside the doSomeStuff method");
        this.fortuneService = fortuneService;
    }*/

    @Override
    public String getDailyWorkout() {
        return ("Practice with the wall");
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
