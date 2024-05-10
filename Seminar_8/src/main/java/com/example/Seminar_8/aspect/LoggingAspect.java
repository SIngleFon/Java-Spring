package com.example.Seminar_8.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;

import java.util.Arrays;

@Aspect
public class LoggingAspect {
    /**
     *
     * @param joinPoint - перехвачиваемый метод
     * @param returnedValue - возвращаемый методом объект
     *                      Метод для вывода (имени метода, аргументов вывода,
     *                      каким классом вызывался и какие объекты возвращает)
     */
    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returnedValue")
    public void log(JoinPoint joinPoint, Object returnedValue) {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("\nName method: "+methodName+"\n"+
                "Args method: "+ Arrays.asList(args)+"\n"+
                "Who volunteered: "+joinPoint.getTarget().getClass()+"\n"+
                "Method returns: "+returnedValue.getClass());
    }


}
