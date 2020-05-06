package com.lhh.scheduletask.task;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

/**
 * DynamicScheduleTask
 *
 * @author 李弘昊
 * @since 2020/5/5
 */
@Configuration
//@EnableScheduling
public class DynamicScheduleTask implements SchedulingConfigurer {

    @Mapper
    public interface  CronMapper
    {
        @Select("select cron from cron limit 1")
        String getCron();
    }

    @Autowired
    @SuppressWarnings("all")
    CronMapper cronMapper;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar)
    {

        taskRegistrar.addTriggerTask(
                () -> System.out.println("执行动态定时任务：" + LocalDateTime.now().toLocalTime()),
                triggerContext -> {
                    String cron = cronMapper.getCron();
                    if (StringUtils.isEmpty(cron))
                    {

                    }
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );

    }
}
