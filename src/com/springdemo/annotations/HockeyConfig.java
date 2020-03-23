package com.springdemo.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HockeyConfig {

    @Bean
    public IceService iceService(){
        return new IceService();
    }

    @Bean
    public Coach hockeyCoach(){
        return new HockeyCoach(iceService());
    }
}
