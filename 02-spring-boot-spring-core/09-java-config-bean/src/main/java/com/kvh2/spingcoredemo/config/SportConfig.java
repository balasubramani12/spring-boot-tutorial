package com.kvh2.spingcoredemo.config;

import com.kvh2.spingcoredemo.common.Coach;
import com.kvh2.spingcoredemo.common.SwimCoach;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    } 
        
}
