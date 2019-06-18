package com.top.sstore.common;

import com.top.sstore.service.IUserService;
import com.top.sstore.utils.StaticValues;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StaticValues staticValues;
    @Autowired
    private IUserService userService;

//    @Pointcut("execution(public * com.top.sstore.controller..*.*(..))")
    public void executeService(){ }

//    @Around(value = "executeService()")
    public void signInAdvice(ProceedingJoinPoint proceedingJoinPoint){
        //通知的签名
//        Signature signature = joinPoint.getSignature();
        System.out.println("环绕通知的目标方法名："+proceedingJoinPoint.getSignature().getName());
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Before("execution(* com.top.sstore.controller.*.s_*(..))")   //controller层请求拦截
    public void log(JoinPoint joinPoint){
        /* 切入类joinPoint.getTarget().getClass()；参数Arrays.asList(joinPoint.getArgs())； 切入方法joinPoint.getSignature()；*/
//        logger.info("after method log done "+joinPoint.getTarget().getClass()+",args="+ Arrays.asList(joinPoint.getArgs())+",method="+joinPoint.getSignature().getName());

        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
//        System.out.println("session:"+session.getAttribute("userAccountId")); //获取成功
        boolean b = userService.checkUserId((Integer) session.getAttribute(staticValues.getSessionUserId()));
        if (b)
            return;
        throw new RuntimeException("未登录");   //未登录，抛异常
    }

    @Before("execution(* com.top.sstore.controller.*.*(..))")
    public void setLogger(JoinPoint joinPoint){
        //通知的签名
        Signature signature = joinPoint.getSignature();
        logger.info("Controller Logger: "+joinPoint.getTarget().getClass()+" "+signature.getName());
    }


    //可以通过JoinPoint取到aop的类名，方法参数，方法签名
//    @After("execution(* com.top.sstore.service..*.*(..))")
    public void logAfter(JoinPoint joinPoint){
        logger.info("after method log done "+joinPoint.getTarget().getClass()+",args="+ Arrays.asList(joinPoint.getArgs())+",method="+joinPoint.getSignature());
    }
}
