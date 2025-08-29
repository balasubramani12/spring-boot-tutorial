package com.kvh2.spingcoredemo.rest;

import org.springframework.web.bind.annotation.RestController;

import com.kvh2.spingcoredemo.common.Coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DemoController {
    //Define field for depedency
    private Coach myCoach;

    
    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach theCoach){
        System.out.println("In Constructor: "+ getClass().getSimpleName());
        myCoach = theCoach;
    }
    // Define a path for endpoint
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
    
}
