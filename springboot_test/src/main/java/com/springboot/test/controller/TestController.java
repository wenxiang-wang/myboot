package com.springboot.test.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class TestController {

    @RequestMapping("hello")
    public String toHello() {

        log.info("start hello");
        return "hello Springboot Test";
    }
}
