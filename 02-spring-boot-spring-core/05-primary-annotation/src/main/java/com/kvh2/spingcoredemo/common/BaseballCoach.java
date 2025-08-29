package com.kvh2.spingcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Hey Baseball Coach here, Do Scrolling Down!!!";
    }


}
