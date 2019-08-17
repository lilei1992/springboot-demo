package com.fsd.fsdredislock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class FsdRedislockApplication {

    public static void main(String[] args) {
        SpringApplication.run(FsdRedislockApplication.class, args);
    }

}
