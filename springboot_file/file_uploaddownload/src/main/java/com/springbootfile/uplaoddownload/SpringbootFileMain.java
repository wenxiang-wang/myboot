package com.springbootfile.uplaoddownload;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class SpringbootFileMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFileMain.class, args);
        log.info("hello log4j2");
    }
}
