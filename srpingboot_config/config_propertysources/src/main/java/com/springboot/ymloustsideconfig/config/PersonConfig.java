package com.springboot.ymloustsideconfig.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Data
@ToString
@Configuration
@PropertySources(@PropertySource(value = "classpath:person.properties", encoding = "UTF-8"))
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
