package com.kvh2.spingcoredemo.common;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component

public class CricketCoach implements Coach{
    
    public CricketCoach(){
        System.out.println("In Constructor: "+ getClass().getSimpleName());
    }
    // Define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff(): "+ getClass().getSimpleName());
    }

    //Define our destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff(): "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Hey Cricket Coach Here, Do Hitting!";
    }
}
