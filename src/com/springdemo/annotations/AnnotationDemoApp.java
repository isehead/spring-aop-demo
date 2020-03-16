package com.springdemo.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        // read Spring config file
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from Spring container
        Coach theCoach = applicationContext.getBean("tennisCoach", Coach.class);

        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());

        // call a method to get daily fortune
        System.out.println(theCoach.getDailyFortune());

        // close the context
        applicationContext.close();

    }

}
