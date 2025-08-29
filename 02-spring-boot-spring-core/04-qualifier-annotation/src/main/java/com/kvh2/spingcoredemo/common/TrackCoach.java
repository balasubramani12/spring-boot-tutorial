package com.kvh2.spingcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return "Hey Track Coach here, Do Wait for sometime......";
    }

}
