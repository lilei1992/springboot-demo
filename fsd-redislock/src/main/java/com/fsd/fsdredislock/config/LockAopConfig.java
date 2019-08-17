package com.fsd.fsdredislock.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * created by lilei
 * since 2019/8/17
 **/
@Aspect
@Component
public class LockAopConfig {

    @Pointcut(value="@annotation(com.fsd.fsdredislock.config.Lock)")
    public void aspect(){

    }

@Around(value="aspect()")
    public void around(ProceedingJoinPoint pjp){

     Object proceed;
    try{
        System.out.println("开始");
        proceed = pjp.proceed();
        System.out.println("结束");
    }catch (Throwable e){
        e.printStackTrace();
    }finally {

    }

}


}
