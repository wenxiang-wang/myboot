# 使用@ConfigurationProperties 读取application.yml配置文件

## applicaton.yml文件配置

```yml
server:
  port: 9090

person:
  name: "张三"
  age: 100
  message: "小明的同学"
  method: "ConfigurationProperties"
```

## 使用@ConfigurationProperties批量去取

```java
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "person")
public class PersonConfig {

    private String name;

    private Integer age;

    private String message;

    private String  method;

}
```

## controller类

```java
@RestController
public class ConfigController {

    @Resource
    private PersonConfig personConfig;

    @RequestMapping("configurationProperties")
    public String getCOnfiguration(){
        return personConfig.toString();
    }
}
```

## 结果

```java
PersonConfig(name=张三, age=100, message=小明的同学, method=ConfigurationProperties)
```

## @ConfigurationProperties注意事项

> 1.
确保添加了@EnableConfigurationProperties注解：为了使@ConfigurationProperties生效，需要在主配置类上添加@EnableConfigurationProperties(
value=xxxxProperties.class)注解，开启@ConfigurationProperties注解自动装配功能。
> 2.
配置文件中的属性名与类字段名的映射规则：默认情况下，@ConfigurationProperties会将配置文件中的属性名与类字段名进行映射。例如，配置文件中的属性student.name会自动映射到类字段name上。如果配置文件中的属性名与类字段名不一致，可以使用@Value注解或通过setter方法来指定映射关系。
> 3.
类必须是Spring管理的Bean：被@ConfigurationProperties注解标记的类必须是由Spring容器管理的Bean，因此需要确保该类被@Component或其他相关注解标记，以便Spring能够扫描并创建该类的实例。
> 4. 支持类型转换：@ConfigurationProperties支持自动类型转换，将配置文件中的字符串值转换为目标字段的类型。例如，将字符串转换为整数、布尔值等。如果无法进行类型转换，会抛出异常。
>5. 默认值和可选属性：可以为@ConfigurationProperties注解的字段设置默认值，以防止配置文件中缺少对应的属性。可以使用":
    “符号指定默认值，例如@Value(”${my.property:default-value}")。另外，可以使用required属性来指定某个属性是否为必需的。
>6. 配置项的验证和校验：可以使用JSR-303/349规范的注解对@ConfigurationProperties注解的字段进行验证和校验。例如，使用@NotBlank、@Min、@Max等注解来限制属性值的有效性。