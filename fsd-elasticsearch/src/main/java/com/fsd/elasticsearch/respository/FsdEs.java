package com.fsd.elasticsearch.respository;

import com.fsd.elasticsearch.FsdElasticsearchApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * created by lilei
 * since 2019/8/4
 **/
public class FsdEs {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(FsdElasticsearchApplication.class);
        ItemRepository item = (ItemRepository) ctx.getBean("itemController");

    }
}
