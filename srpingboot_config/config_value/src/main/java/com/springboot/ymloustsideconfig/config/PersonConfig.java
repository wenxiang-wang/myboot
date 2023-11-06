package com.springboot.ymloustsideconfig.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
public class PersonConfig {

    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private Integer age;

    @Value("${person.message}")
    private String message;

    @Value("${person.method}")
    private String method;
}
