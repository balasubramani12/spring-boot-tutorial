package com.kvh2.spingcoredemo.common;

public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("In Constructor: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Swim across the river of 10mts long";
    }
}
