package com.springdemo.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IceConfigDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(HockeyConfig.class);

        HockeyCoach theCoach = applicationContext.getBean("hockeyCoach", HockeyCoach.class);

        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getDailyWorkout());

        applicationContext.close();
    }

}
