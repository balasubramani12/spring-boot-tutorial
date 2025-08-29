package com.kvh2.spingcoredemo.common;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TennisCoach implements Coach{
    
    @Override
    public String getDailyWorkout(){
        return "Hi Tennis Coach here, Do some shot practice for 10 mins.";
    }
}
