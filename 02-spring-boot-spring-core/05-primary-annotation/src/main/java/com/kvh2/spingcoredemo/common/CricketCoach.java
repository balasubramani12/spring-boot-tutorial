package com.kvh2.spingcoredemo.common;

import org.springframework.stereotype.Component;


@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return "Hey Cricket Coach Here, Do Hitting!";
    }
}
