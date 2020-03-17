package com.springdemo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    public TennisCoach(){
        System.out.println("TennisCoach - inside the default constructor");
    };

/*    @Autowired
    public TennisCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }*/

    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("TennisCoach - inside the setter");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return ("Practice with the wall");
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
