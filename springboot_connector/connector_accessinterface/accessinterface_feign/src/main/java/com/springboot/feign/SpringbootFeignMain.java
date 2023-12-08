package com.springboot.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringbootFeignMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFeignMain.class);
    }
}
