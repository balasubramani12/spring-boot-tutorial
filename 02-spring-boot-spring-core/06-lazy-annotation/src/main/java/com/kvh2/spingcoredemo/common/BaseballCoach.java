package com.kvh2.spingcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    public BaseballCoach(){
        System.out.println("In Constructor: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Hey Baseball Coach here, Do Scrolling Down!!!";
    }


}
