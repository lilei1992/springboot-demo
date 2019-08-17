package com.fsd.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
@ComponentScan("com.fsd")
public class FsdElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(FsdElasticsearchApplication.class, args);
    }

}
