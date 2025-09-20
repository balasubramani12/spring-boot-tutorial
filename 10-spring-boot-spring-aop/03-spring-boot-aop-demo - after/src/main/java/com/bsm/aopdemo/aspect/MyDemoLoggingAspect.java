package com.bsm.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import com.bsm.aopdemo.Account;
import com.bsm.aopdemo.aspect.AOPCommonPointcut;


@Aspect
@Component
@Order(7)
public class MyDemoLoggingAspect {

    @Around("execution(* com.bsm.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune( 
        ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method: " + method);

        // now, let's execute the method
        Object result = null;

        try{
            result = theProceedingJoinPoint.proceed();
        }
        catch(Exception e){
            // log the exception
            System.out.println("@Around Advice: we have a problem, "+e);

            //handle and give default fortune ... use this approach with caution
            result = "Nothing exciting here. Move Along";
            // rethrow the exception
            throw e;
        }

        return result;
    }
    /*
    @Around("execution(* com.bsm.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune( 
        ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = theProceedingJoinPoint.proceed();
       

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n=====>>> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.bsm.aopdemo.dao.AccountDAO.findAccounts(..))")  
    public void afterFinallyAccountAdvice(JoinPoint theJoinPoint) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " + method);

    }

    @AfterThrowing(
        pointcut = "execution(* com.bsm.aopdemo.dao.AccountDAO.findAccounts(..))",
        throwing = "theExc")
    public void afterThrowingFindAccounts(JoinPoint theJoinPoint, Exception theExc) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        // log the exception
        System.out.println("\n=====>>> The exception is: " + theExc);
        
    }
    @AfterReturning(
        pointcut = "execution(* com.bsm.aopdemo.dao.AccountDAO.findAccounts(..))",
        returning = "result")
    public void afterReturningFindAccounts(JoinPoint theJoinPoint, List<Account> result) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        // post-process the data ... let's modify it :-)
        // convert the account names to uppercase
        for (Account tempAccount : result) {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }

        // print out the results of the method call
        System.out.println("\n=====>>> Result is: " + result);
    }

    @Before("com.bsm.aopdemo.aspect.AOPCommonPointcut.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Executing Demo Aspect.");
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSig);
    }
     */
}

