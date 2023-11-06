package com.springboot.ymloustsideconfig.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
@ConfigurationProperties(prefix = "person")
public class PersonConfig {

    private String name;

    private Integer age;

    private String message;

    private String method;

}
