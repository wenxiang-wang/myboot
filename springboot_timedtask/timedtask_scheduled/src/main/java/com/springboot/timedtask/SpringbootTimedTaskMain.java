package com.springboot.timedtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootTimedTaskMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootTimedTaskMain.class, args);
    }
}
