package com.spring.aopdemo;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {

    public static void main(String[] args) {
        // read the spring config class
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService trafficFortuneService =
                applicationContext.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("MAIN program: demo app, calling getFortune()...");
        String data = trafficFortuneService.getFortune();

        System.out.println("The fortune is: " + data);

        // close the context
        applicationContext.close();

    }
}
