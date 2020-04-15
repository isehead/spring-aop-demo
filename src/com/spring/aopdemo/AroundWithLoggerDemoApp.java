package com.spring.aopdemo;

import com.spring.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

    private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {
        // read the spring config class
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService trafficFortuneService =
                applicationContext.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("===== MAIN program =====: @Around demo app, calling getFortune()...");
        String data = trafficFortuneService.getFortune();

        logger.info("=== MAIN === The fortune is: " + data);

        // close the context
        applicationContext.close();

    }
}
