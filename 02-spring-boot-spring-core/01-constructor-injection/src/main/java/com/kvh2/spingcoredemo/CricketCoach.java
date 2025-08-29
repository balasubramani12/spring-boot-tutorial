package com.kvh2.spingcoredemo;

import org.springframework.stereotype.Component;


@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return "Do 10 mins Warmup, then Practice Fast Bowling for 30 mins";
    }
}
