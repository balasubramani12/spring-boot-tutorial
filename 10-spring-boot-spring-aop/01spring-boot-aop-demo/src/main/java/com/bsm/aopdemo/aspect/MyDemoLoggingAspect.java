package com.bsm.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // add all the related advices for logging

    // let's start with an @Before advice
    @Before("execution(* com.bsm.aopdemo.dao.AccountDAO.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on DAO any add****()");
    }

}
