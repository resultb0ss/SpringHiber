package com.kaz.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = Logger.getLogger(LoggingAspect.class);

    @Before("execution(* com.kaz.spring.mvc_hibernate_aop.service.*.*(..)) || execution(* com.kaz.spring.mvc_hibernate_aop.dao.*.*(..))")
    public void beforeAnyServiceOrDaoMethod(JoinPoint joinPoint) {
        logger.info("➡ [Before] " + joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "execution(* com.kaz.spring.mvc_hibernate_aop.service.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("[After Returning] " + joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(pointcut = "execution(* com.kaz.spring.mvc_hibernate_aop..*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        logger.error("[Exception] in: " + joinPoint.getSignature().toShortString(), ex);
    }
}
