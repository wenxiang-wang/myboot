package com.springboot.ymloustsideconfig.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.Objects;

@Configuration
public class PersonYmlOutsideConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer yamlConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("person.yml"));//自定义yml文件
        //Objects.requireNonNull()方法的作用是如果对象为空，则抛出空指针异常，否则返回对象本身。
        configurer.setProperties(Objects.requireNonNull(yaml.getObject()));
        return configurer;
    }
}
