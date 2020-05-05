package com.lhh.scheduletask.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * StaticScheduleTask
 *
 * @author 李弘昊
 * @since 2020/5/5
 */
@Configuration
@EnableScheduling
public class StaticScheduleTask {

    @Scheduled(cron = "0/5 * * * * ?")
    //@Scheduled(fixedRate = 5000)
    private void configureTasks()
    {
        System.err.println("执行静态定时任务时间：" + LocalDateTime.now());
    }
}
