package com.rafael.api.normalize.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.rafael.api.normalize.controller.*.*(..))")
    public void logControllerMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        MDC.put("source", "controller");
        logger.info("[Controller method]: {} arguments: {}", methodName, joinPoint.getArgs());
    }

    @Before("execution(* com.rafael.api.normalize.service.*.*(..))")
    public void logServiceMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        MDC.put("source", "service");
        logger.info("[Service method]: {} arguments: {}", methodName, joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.rafael.api.normalize.controller.*.*(..))", returning = "result")
    public void logControllerMethodReturn(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("[Controller method]: {} returned: {}", methodName, result);
        MDC.clear();
    }

    @AfterReturning(pointcut = "execution(* com.rafael.api.normalize.service.*.*(..))", returning = "result")
    public void logServiceMethodReturn(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("[Service method]: {} returned: {}", methodName, result);
        MDC.clear();
    }
}


