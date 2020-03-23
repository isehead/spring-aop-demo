package com.springdemo.annotations;

public class HockeyCoach implements Coach {

    private IceService iceService;

    public HockeyCoach(IceService iceService) {
        this.iceService = iceService;
    }

    @Override
    public String getDailyWorkout() {
        return ("Strike 10 shots on skating");
    }

    @Override
    public String getDailyFortune() {
        return iceService.getFortune();
    }
}
