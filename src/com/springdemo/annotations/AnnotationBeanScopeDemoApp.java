package com.springdemo.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {

        // load Spring config file
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from Spring container
        Coach theCoach = applicationContext.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = applicationContext.getBean("tennisCoach", Coach.class);

        // check if references point to the same object
        boolean result = (theCoach == alphaCoach);

        // print the result
        System.out.println("Pointing to the same object: " + result);
        System.out.println("Memory location of theCoach: " + theCoach);
        System.out.println("Memory location of alphaCoach: " + alphaCoach);

        // close the context
        applicationContext.close();
    }

}
