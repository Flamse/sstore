package com.top.sstore.Study;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Before("execution(* com.top.sstore.Study..*.*(..))")
    public void log(){
        System.out.println("method log done.");
    }

}
