package com.fsd.fsdredislock.config.lock;

import java.lang.annotation.*;

/**
 * created by lilei
 * since 2019/8/17
 **/

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLock {
    String description()  default "";

}
