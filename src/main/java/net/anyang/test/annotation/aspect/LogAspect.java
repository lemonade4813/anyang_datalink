package net.anyang.test.annotation.aspect;

import lombok.With;
import lombok.extern.slf4j.Slf4j;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;




@Slf4j
@Aspect
@Component
public class LogAspect {


    @Pointcut("execution(* net.anyang.test.controller..*.common(..))")
    private void commmonAround(){}

    @Pointcut("execution(* net.anyang.test.controller..*.*(..))")
    private void cut(){}

    @Around("commmonAround()")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        log.info("start : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        Object result = pjp.proceed();
        log.info("finished : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        return result;
    }

    @Before("cut()")
    public void beforeLogging(JoinPoint point) {
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        log.info("Run MethodName ======> " + className + "." +methodName);
    }
}
