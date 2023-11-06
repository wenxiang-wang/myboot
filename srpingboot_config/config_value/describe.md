# 使用@value 读取application.yml配置文件

## applicaton.yml文件配置

```yml
server:
  port: 9090

person:
  name: "张三"
  age: 100
  message: "小明的同学"
  method: "value"
```

## 使用@value读取配置文件

```java
@ToString
@Component
public class PersonConfig {

    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private Integer  age;

    @Value("${person.message}")
    private String message;

    @Value("${person.method}")
    private String  method;
}
```

## controller类

```java
@RestController
public class ConfigController {
    @Resource
    private PersonConfig personConfig;

    @RequestMapping("value")
    public String getCOnfiguration(){
        return personConfig.toString();
    }
}
```

## 结果

```java
PersonConfig(name=张三, age=100, message=小明的同学, method=value)
```

## @value注意事项

> 1. @Value注解只能读取单个配置进行赋值，无法读取整个配置文件批量赋值。当使用@Value注解读取配置时，确保配置在yml中存在，否则启动程序时就会报错。注解中属性名引用方式如下：

```yml
@Value("${一级属性名.二级属性名...}")

```

> 2. 当使用@Value注解引用属性时，可以在属性名称后面使用冒号（:
     default-value）的形式添加默认值。这样，如果在配置文件中找不到对应的属性，就会使用默认值。如果在配置文件中找到了属性，其值将会覆盖默认值。

```java
//可以使用各种类型的默认值，包括字符串、数字、布尔值等
@Value("${person.name:aopmin}")
private String name;

@Value("${person.age:18}")
private Integer age;

//表示一个空字符串作为默认值
@Value("${student.name:}")
private String name;
```

> 3. @Value注解只能用于被Spring管理的Bean中使用，，如使用@Component、@Service、@Controller等注解修饰的类，或者使用Java配置编写的@Configuration类中。

> 4. @Value注解可以用于字段、构造函数参数、方法参数和方法上。当将它放在方法上时，Spring容器初始化时会调用该方法，并将配置属性的值作为方法的参数传递进去。

```java
@Component
public class MyBean {

    private String myProperty;

    @Autowired
    public MyBean(@Value("${my.property}") String myProperty) {
        this.myProperty = myProperty;
    }

    @Value("${another.property}")
    public void setAnotherProperty(String anotherProperty) {
        // do something with anotherProperty...
    }

    @Value("${yet.another.property}")
    public void processValue(String value) {
        // do something with value...
    }
    
}

/*
@Value注解被用于构造函数参数、setter方法和普通方法上。容器初始化时，会将配置属性的值作为参数传递到构造函数、setter方法和普通方法中。
*/
```

> 5.
@Value注解不能在static修饰的字段上使用。因为@Value注解是通过访问Spring容器中的上下文来解析属性值并注入到目标字段中的。由于static字段不属于对象实例，无法通过实例访问容器，所以在静态字段上使用@Value注解是无效的。

