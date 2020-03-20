package com.springdemo.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {

        // read Spring config java class
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from Spring container
        // duplicated to inject values from properties file
        // Coach theCoach = applicationContext.getBean("swimCoach", Coach.class);
        SwimCoach theCoach = applicationContext.getBean("swimCoach", SwimCoach.class);

        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());

        // call a method to get daily fortune
        System.out.println(theCoach.getDailyFortune());

        // call new SwimCoach methods with properties injected
        System.out.println("Email: " + theCoach.getEmail());
        System.out.println("Team: " + theCoach.getTeam());

        // close the context
        applicationContext.close();

    }

}
