package com.fsd.fsdredislock.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * created by lilei
 * since 2019/8/10
 **/
public class RedisLockAop {
    ThreadLocal<Long> beginTime = new ThreadLocal<>();
    ThreadLocal<String> objectId = new ThreadLocal<>();
    ThreadLocal<String> lockValue = new ThreadLocal<>();

    @Autowired
    private RedisService redisService;

    @Pointcut("@annotation(redisLock)")
    public void serviceStatistics(RedisLock redisLock) {
    }

    @Before("serviceStatistics(redisLock)")
    public void doBefore(JoinPoint joinPoint, RedisLock redisLock) {
        // 记录请求到达时间
        beginTime.set(System.currentTimeMillis());
        //注解所在方法名
        String methodName = joinPoint.getSignature().getName();
        //注解所在类
        String className = joinPoint.getSignature().getDeclaringTypeName();
        //方法上的参数
        Object[] args = joinPoint.getArgs();
        String key = redisLock.key();
        if(ObjectUtils.isNullOrEmpty(args)){
            //方法的参数是空，生成永远不重复的uuid,相当于不做控制
            key = methodName +  UUID.randomUUID().toString();
        }else {
            //取第一个参数指定字段,若没有指定，则取id字段
            Object arg = args[0];
            log.info("arg:"+arg.toString());
            Map<String, Object> map = getKeyAndValue(arg);
            Object o = map.get(StringUtils.isEmpty(key) ? "id" : key);
            if(ObjectUtils.isNullOrEmpty(o)){
                //自定义异常，可以换成自己项目的异常
                throw new MallException(RespCode.REDIS_LOCK_KEY_NULL);
            }
            key = o.toString();
        }
        log.info("线程："+Thread.currentThread().getName() + "， 已进入方法："+className+"."+methodName);
//        objectId.set(StringUtils.isEmpty(redisLock.key()) ? UserUtils.getCurrentUser().getId() : redisLock.key());
        objectId.set(key);
        String lock = redisService.redisLock(objectId.get(), redisLock.acquireTimeout(), redisLock.timeout());
        lockValue.set(lock);
        log.info("objectId:"+objectId.get()+",lockValue:"+lock +",已经加锁！");
    }


    @After("serviceStatistics(redisLock)")
    public void doAfter(JoinPoint joinPoint,RedisLock redisLock) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        redisService.releaseLock(objectId.get(),lockValue.get());
        log.info("objectId:"+objectId.get()+",lockValue:"+lockValue.get() +",已经解锁！");
        log.info("线程："+Thread.currentThread().getName() + "， 已退出方法："+className+"."+methodName+",耗时："+(System.currentTimeMillis() - beginTime.get() +" 毫秒！"));
    }


    //这是一个Object转mapd的方法
    public static Map<String, Object> getKeyAndValue(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 得到类对象
        Class userCla = (Class) obj.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = userCla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true); // 设置些属性是可以访问的
            Object val = new Object();
            try {
                val = f.get(obj);
                // 得到此属性的值
                map.put(f.getName(), val);// 设置键值
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            /*
             * String type = f.getType().toString();//得到此属性的类型 if
             * (type.endsWith("String")) {
             * System.out.println(f.getType()+"\t是String"); f.set(obj,"12") ;
             * //给属性设值 }else if(type.endsWith("int") ||
             * type.endsWith("Integer")){
             * System.out.println(f.getType()+"\t是int"); f.set(obj,12) ; //给属性设值
             * }else{ System.out.println(f.getType()+"\t"); }
             */

        }
        System.out.println("单个对象的所有键值==反射==" + map.toString());
        return map;
    }
}
