package com.fsd.fsdredislock.redis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * created by lilei
 * since 2019/8/10
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisLock {

    //被锁的数据的id
    String key() default "";

    //唤醒时间
    long acquireTimeout() default 6000L;

    //超时时间
    long timeout() default 6000L;

}
