package com.springdemo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class FootballCoach implements Coach {

    private MySampleFortuneService mySampleFortuneService;

    @Value("${foo.fortune1}")
    private String fortune1;

    @Value("${foo.fortune2}")
    private String fortune2;

    @Value("${foo.fortune3}")
    private String fortune3;

    @Autowired
    public FootballCoach(@Qualifier("mySampleFortuneService") MySampleFortuneService mySampleFortuneService) {
        this.mySampleFortuneService = mySampleFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return ("Strike 20 kicks on target");
    }

    @Override
    public String getDailyFortune() {
        Random random = new Random();
        return fortunes[random.nextInt(3)];
    }

    private String[] fortunes;
    @PostConstruct
    public void loadFortunes(){
        fortunes = new String[3];
        fortunes[0] = fortune1;
        fortunes[1] = fortune2;
        fortunes[2] = fortune3;
    }

}
