package com.lhh.scheduletask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//EnableSchduling会开启所有的定时任务
//@EnableScheduling
public class ScheduletaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduletaskApplication.class, args);
    }

}
