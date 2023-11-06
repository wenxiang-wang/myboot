package com.springboot.ymloustsideconfig.controller;

import jakarta.annotation.Resource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Resource
    private Environment environment;

    @RequestMapping("environment")
    public String getCOnfiguration() {
        String name = environment.getProperty("person.name");
        String age = environment.getProperty("person.age");
        String message = environment.getProperty("person.message");
        String method = environment.getProperty("person.method");
        return "PersonConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", message='" + message + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
