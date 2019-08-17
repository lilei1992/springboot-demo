package com.fsd.fsdaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * created by lilei
 * since 2019/7/21
 **/
@Aspect
@Configuration
public class PersonAspectJ {


    @Pointcut("execution(* *.say(..))")
    public void test(){
        System.out.println("你好");
    }

    @Before("test()")
    public void before(){
        System.out.println("before test..");
    }

    @After("test()")
    public void after(){
        System.out.println("after test..");
    }

    @Around("test()")
    public Object around(ProceedingJoinPoint p){
        System.out.println(" around before");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("around after");
        return o;
    }
}
