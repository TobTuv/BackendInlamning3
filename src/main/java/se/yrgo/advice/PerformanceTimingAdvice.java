package se.yrgo.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceTimingAdvice {

    @Around("execution(* se.yrgo.services..*(..)) || execution(* se.yrgo.dataaccess..*(..))")
    public Object timeMethod(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.nanoTime();

        Object result = pjp.proceed();

        long end = System.nanoTime();

        double durationMs = (end - start) / 1_000_000.0;

        System.out.println("Time taken for the method " +
                pjp.getSignature().getName() +
                " from the class " +
                pjp.getTarget().getClass().getName() +
                " took " + durationMs + "ms");

        return result;
    }
}
