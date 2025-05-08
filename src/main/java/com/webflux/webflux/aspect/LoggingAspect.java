package com.webflux.webflux.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controllerMethods(){}

    @Before("controllerMethods()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Executing Before Method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result){
        System.out.println("Executing After Method: " + joinPoint.getSignature().getName() + "return: " + result);
    }

    @AfterThrowing(pointcut = "controllerMethods()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception){
        System.err.println("Executing After Throwing Method: " + joinPoint.getSignature().getName() + ": " + exception.getMessage());
    }
}
