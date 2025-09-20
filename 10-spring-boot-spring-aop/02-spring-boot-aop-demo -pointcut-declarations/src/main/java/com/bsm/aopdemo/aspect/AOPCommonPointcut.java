package com.bsm.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPCommonPointcut {
     // add all the related advices for logging
    @Pointcut("execution(* com.bsm.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.bsm.aopdemo.dao.*.get*(..))")
    public void getter() {}
    @Pointcut("execution(* com.bsm.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
