package com.nz.supplieritem.filter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {

    @Around("execution(public * com.nz.supplieritem.controller.user.*.*(..))")
    public Object  handleUserControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        long l1 = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        long l2 = System.currentTimeMillis();
        System.out.println("执行请求耗时 ： " + (l2-l1));
        return proceed;
    }
}
