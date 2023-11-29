package com.springboot.timedtask.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskScheduling {
    @Scheduled(cron = "1/1 * * * * ?")
    public void taskOne() {
        System.out.println("springboot任务调度:每秒执行一次");
    }

}
