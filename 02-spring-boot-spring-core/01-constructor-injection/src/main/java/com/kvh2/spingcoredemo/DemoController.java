package com.kvh2.spingcoredemo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DemoController {
    //Define field for depedency
    private Coach myCoach;

    // Define a constructor for dependency Injection
    @Autowired
    public DemoController(Coach myCoach){
        this.myCoach = myCoach;
    }
    // Define a path for endpoint
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
    
}
