package com.springdemo.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAnnotationDemoApp {

    public static void main(String[] args) {

        // read Spring config file
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("myApplicationContext.xml");

        // get the bean from Spring container
        Coach theCoach = applicationContext.getBean("soccerCoach", Coach.class);

        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());

        // call a method to get daily fortune
        System.out.println(theCoach.getDailyFortune());

        // close the context
        applicationContext.close();

    }

}
