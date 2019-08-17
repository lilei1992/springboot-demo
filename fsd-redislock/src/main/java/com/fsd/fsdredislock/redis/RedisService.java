package com.fsd.fsdredislock.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * created by lilei
 * since 2019/8/10
 **/
@Service
public class RedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Resource(name = "stringRedisTemplate")
    @Autowired
    ValueOperations valOpsStr;

    @Autowired
    RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations valOpsObj;

    public String getStr(String key) {
        return stringRedisTemplate.opsForValue().get(key);//获取对应key的value
        //        return valOpsStr.get(key);
    }

    public void setStr(String key, String val) {
        stringRedisTemplate.opsForValue().set(key,val,1800, TimeUnit.SECONDS);
        //        valOpsStr.set(key, val);
    }

    public void del(String key) {
        stringRedisTemplate.delete(key);
    }


    /**
     * 根据指定o获取Object
     *
     * @param o
     * @return
     */
    public Object getObj(Object o) {
        return valOpsObj.get(o);
    }

    /**
     *       * 设置obj缓存
     *       * @param o1
     *       * @param o2
     *
     */
    public void setObj(Object o1, Object o2) {
        valOpsObj.set(o1, o2);
    }

    /**
     * 删除Obj缓存
     *
     * @param o
     */
    public void delObj(Object o) {
        redisTemplate.delete(o);
    }


    private static JedisPool pool = null;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(200);
        // 设置最大空闲数
        config.setMaxIdle(8);
        // 设置最大等待时间
        config.setMaxWaitMillis(1000 * 100);
        // 在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例均是可用的
        config.setTestOnBorrow(true);
        pool = new JedisPool(config, "127.0.0.1", 6379, 3000);
    }


    DistributedLock lock = new DistributedLock(pool);

    /**
     * redis分布式加锁
     * @param objectId
     * @param acquireTimeout
     * @param timeout
     */
    public String redisLock(String objectId,Long acquireTimeout, Long timeout) {
        // 对key为id加锁, 返回锁的value值，供释放锁时候进行判断
        String lockValue = lock.lockWithTimeout(objectId, acquireTimeout, timeout);
        System.out.println(Thread.currentThread().getName() + "获得了锁");
        return lockValue;
    }


    /**
     * 释放redis分布式锁
     * @param objectId
     * @param lockValue
     */
    public Boolean  releaseLock(String objectId,String lockValue){
        boolean b = lock.releaseLock(objectId, lockValue);
        System.out.println(Thread.currentThread().getName() + "释放了锁");
        return b;
    }

}
