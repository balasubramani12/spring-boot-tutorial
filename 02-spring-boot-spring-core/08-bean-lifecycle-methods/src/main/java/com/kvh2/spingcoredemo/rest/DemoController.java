package com.kvh2.spingcoredemo.rest;

import org.springframework.web.bind.annotation.RestController;

import com.kvh2.spingcoredemo.common.Coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class DemoController {
    //Define field for depedency
    private Coach myCoach;

    

    
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach
    ){
        myCoach = theCoach;
    }
    // Define a path for endpoint
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }


    
}
