package com.springboot.properties;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@SpringBootTest(classes = SpringbootProperties.class)
public class SpringbootProperties {

    @Test
    public void test() {
        // 配置对象
        Properties props = new Properties();
        InputStreamReader input = null;
        try {
            // 输入流 （字节流转字符流）
            input = new InputStreamReader(
                    this.getClass().getClassLoader().getResourceAsStream("person.properties"),//通过类加载器来获取指定路径下的资源文件，并返回一个InputStream对象
                    StandardCharsets.UTF_8); //指定编码格式
            // 加载配置
            props.load(input);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (input != null)
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("name", props.getProperty("person.name"));
        map.put("age", props.getProperty("person.age"));
        map.put("message", props.getProperty("person.message"));
        map.put("method", props.getProperty("person.method"));
        System.out.println(map.toString());
    }
}
