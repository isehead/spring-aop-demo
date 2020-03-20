package com.springdemo.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport2.properties")
//@ComponentScan("com.springdemo.annotations")
public class SportConfig {

    // define bean for SadFortuneService
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    // define bean for swim coach AND inject dependency
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }

}
