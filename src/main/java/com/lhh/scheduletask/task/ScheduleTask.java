package com.lhh.scheduletask.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * ScheduleTask
 *
 * @author 李弘昊
 * @since 2020/5/5
 */

@Component
@EnableScheduling
public class ScheduleTask {

    @Scheduled(cron = "${demo.cron}")
    public void scheduleTaskByConfig()
    {
        System.err.println("定时任务 ByConfig：" + LocalDateTime.now());
    }

}
