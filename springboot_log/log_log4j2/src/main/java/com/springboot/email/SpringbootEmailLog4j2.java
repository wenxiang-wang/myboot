package com.springboot.email;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class SpringbootEmailLog4j2 {

    /* private final static Logger log  = LoggerFactory.getLogger(SpringbootEmailLog4j2.class);*/
    public static void main(String[] args) {
        SpringApplication.run(SpringbootEmailLog4j2.class);
        log.info("测试");
    }
}
