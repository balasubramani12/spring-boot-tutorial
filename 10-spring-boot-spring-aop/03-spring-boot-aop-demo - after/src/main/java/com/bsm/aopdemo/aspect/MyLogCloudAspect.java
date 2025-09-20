package com.bsm.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(1)
public class MyLogCloudAspect {

    // let's start with an @Before advice
    @Before("com.bsm.aopdemo.aspect.AOPCommonPointcut.forDaoPackageNoGetterSetter()")
    public void logCloudService() {
        System.out.println("\n=====>>> Executing Cloud logging Service");
    }
}
