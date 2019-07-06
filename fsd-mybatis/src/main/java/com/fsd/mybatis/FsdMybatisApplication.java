package com.fsd.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fsd.mybatis.mapper")
public class FsdMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(FsdMybatisApplication.class, args);
    }

}
