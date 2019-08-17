package com.fsd.fsdaop.aop;

import org.springframework.stereotype.Component;

/**
 * created by lilei
 * since 2019/7/21
 **/
@Component
public class Student implements Person{
    @Override
    public void say() {
        System.out.println("say...");
    }
}
