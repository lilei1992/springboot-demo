package com.fsd.mybatis.config;

import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * created by lilei
 * since 2019/8/17
 **/
@Component
public class ScheduleTask {
    private static final int FOURTEEN_MIN = 14 * 60 * 1000;


    @Scheduled(cron = "0 */15 * * * *")
    @SchedulerLock(name = "scheduledTaskName", lockAtMostFor = FOURTEEN_MIN, lockAtLeastFor = FOURTEEN_MIN)
    public void scheduledTask() {
        // do something

    }

}
