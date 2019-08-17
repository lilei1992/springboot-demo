package com.fsd.fsdredislock.config;

import java.lang.annotation.*;

/**
 * created by lilei
 * since 2019/8/17
 **/
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Lock {

    String key();
}
