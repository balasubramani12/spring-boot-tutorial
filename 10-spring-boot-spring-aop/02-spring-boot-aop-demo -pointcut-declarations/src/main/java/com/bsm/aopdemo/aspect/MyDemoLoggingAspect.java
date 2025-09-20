package com.bsm.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import com.bsm.aopdemo.aspect.AOPCommonPointcut;


@Aspect
@Component
@Order(7)
public class MyDemoLoggingAspect {
    // let's start with an @Before advice
    @Before("com.bsm.aopdemo.aspect.AOPCommonPointcut.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Executing Demo Aspect.");

        // step1: display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSig); 

        //step2: display method arguments
        Object[] args = theJoinPoint.getArgs();

        for(Object tempArg : args) {
            System.out.println(tempArg);
            if(tempArg instanceof com.bsm.aopdemo.Account) {
                // downcast and print Account specific stuff
                com.bsm.aopdemo.Account theAccount = (com.bsm.aopdemo.Account) tempArg;
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }

    }

    /*
    @Before("forDaoPackage()")
    public void performAnalytics() {
        System.out.println("\n=====>>> Performing analytics");
        }
     */

    
    

}
