package com.kvh2.spingcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("In Constructor: "+ getClass().getSimpleName());
    }    
    @Override
    public String getDailyWorkout(){
        return "Hi Tennis Coach here, Do some shot practice for 10 mins.";
    }
}
