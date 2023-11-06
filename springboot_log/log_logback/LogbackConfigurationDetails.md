# logback 配置文件详解（待完成）

## logback配置文件（xml文件）总体结构

```xml
?xml version="1.0" encoding="utf-8" ?>
        <!--
        说明：
            1. 文件的命名和加载顺序有关
               logback.xml早于application.yml加载，logback-spring.xml晚于application.yml加载
               如果logback配置需要使用application.yml中的属性，需要命名为logback-spring.xml
            2. logback使用application.yml中的属性
               使用springProperty才可使用application.yml中的值 可以设置默认值
        -->

        <!-- 从高到地低 OFF 、 FATAL 、 ERROR 、 WARN 、 INFO 、 DEBUG 、 TRACE 、 ALL -->
        <!-- 日志输出规则  根据当前ROOT 级别，日志输出时，级别高于root默认的级别时  会输出 -->
        <!-- 以下  每个配置的 filter 是过滤掉输出文件里面，会出现高级别文件，依然出现低级别的日志信息，通过filter 过滤只记录本级别的日志-->

        <!-- 属性描述 scan：性设置为true时，配置文件如果发生改变，将会被重新加载，默认值为true scanPeriod:设置监测配置文件是否有修改的时间间隔，如果没有给出时间单位，
        默认单位是毫秒。当scan为true时，此属性生效。默认的时间间隔为1分钟。debug:当此属性设置为true时，将打印出logback内部日志信息，实时查看logback运行状态。默认值为false。 -->
<configuration scan="true" scanPeriod="60 seconds" debug="false">

    <!-- logger上下文名称（根据业务修改） -->
    <contextName>MyContextName</contextName>

    <!-- 定义了一个名为serverName的属性，它的值来自于配置文件logging.file.name，如果没有找到该属性默认为MyServerName（根据业务修改） -->
    <springProperty name="serverName" source="logging.file.name" defaultValue="MyServerName"/>
    <springProperty name="logging.path" source="logging.file.path" defaultValue="././logs/"/>

    <!-- 彩色日志依赖的渲染类 -->
    <!-- 定义了一个名为clr的转换规则，它使用org.springframework.boot.logging.logback.ColorConverter类进行转换，这个元素通常用于将日志输出中的文本着色，以便更容易地区分不同的日志级别或其他信息 -->
    <conversionRule conversionWord="clr" converterClass="org.springframework.boot.logging.logback.ColorConverter"/>
    <!-- WhitespaceThrowableProxyConverter和ExtendedWhitespaceThrowableProxyConverter都是用于将异常信息转换为字符串，并将其中的换行符替换为空格，以便更容易地在日志输出中显示的类。它们之间的区别在于，ExtendedWhitespaceThrowableProxyConverter在输出异常信息时会包含更多的详细信息，例如异常的类名、方法名和行号等 -->
    <!-- 定义了一个名为wex的转换规则，它使用org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter类进行转换，这个元素通常用于将异常信息转换为字符串，并将其中的换行符替换为空格，以便更容易地在日志输出中显示 -->
    <conversionRule conversionWord="wex"
                    converterClass="org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter"/>
    <!-- 定义了一个名为wEx的转换规则，它使用org.springframework.boot.logging.logback.ExtendedWhitespaceThrowableProxyConverter类进行转换，这个元素通常用于将异常信息转换为字符串，并将其中的换行符替换为空格，以便更容易地在日志输出中显示 -->
    <conversionRule conversionWord="wEx"
                    converterClass="org.springframework.boot.logging.logback.ExtendedWhitespaceThrowableProxyConverter"/>

    <!-- 彩色日志格式 -->
    <!-- value值是日志输出模板， :-是属性名和其默认值之间的分隔符，作用与:相同 -->
    <!-- 定义日志输出格式的转换规则，%d{yyyy-MM-dd HH:mm:ss.SSS}表示日期和时间，%clr表示将输出文本着色，{faint}表示使用淡色 -->
    <!-- %5p表示日志级别输出右对齐，左边以空格填充 -->
    <!-- ${PID:- }表示进程ID，%clr表示将输出文本着色，{magenta}表示使用洋红色 -->
    <!-- ---表示一个分隔符 -->
    <!-- %t：显示产生该日志的线程名；%15：若字符长度小于15，则左边用空格填充；%.15：若字符长度超过15，截去多余字符 -->
    <!-- %-40：若字符长度小于40，则右边用空格填充；%.40：若字符长度超过40，截去多余字符；logger{39}对应的是“logging.WARNING”级别。具体来说，Python的logging模块定义了以下几个级别（从低到高）：NOTSET、DEBUG、INFO、WARNING、ERROR、CRITICAL。因此，logger{39}表示的是WARNING级别，即日志记录器会记录所有WARNING级别及以上的日志信息 -->
    <!-- %m表示日志消息；%n表示换行符；${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}表示异常信息。如果日志输出中包含异常信息，这个规则将会将其转换为字符串，并将其中的换行符替换为空格，以便更容易地在日志输出中显示 -->
    <property name="CONSOLE_LOG_PATTERN"
              value="${CONSOLE_LOG_PATTERN:-%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}"/>

    <!-- 定义日志上下文，可以用%name%引用值（%logPath%） -->
    <property name="logPath" value="./java-starter/${logName}/log"/>

    <!-- 配置项， 通过此节点配置日志输出位置（控制台、文件、数据库）、输出格式等-->
    <!-- ConsoleAppender代表输出到控制台 -->
    <appender name="consoleLog" class="ch.qos.logback.core.ConsoleAppender">
        <!-- layout代表输出格式 -->
        <layout class="ch.qos.logback.classic.PatternLayout">
            <pattern>%date %level [%thread] %logger [%file:%line] %msg%n</pattern>
        </layout>
    </appender>
    <!-- 日志输出文件 -->
    <appender name="fileInfoLog" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <encoder>
            <pattern>%date %level [%thread] %logger [%file:%line] %msg%n</pattern>
        </encoder>
        <!-- 滚动记录文件，先将日志记录到指定文件，当符合某个条件时，将日志记录到其他文件 RollingFileAppender-->
        <!-- 滚动策略，它根据时间来制定滚动策略.既负责滚动也负责触发滚动 -->
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!-- 输出路径 -->
            <fileNamePattern>${logPath}/info/%d.log</fileNamePattern>
            <!-- 可选节点，控制保留的归档文件的最大数量，超出数量就删除旧文件假设设置每个月滚动，且<maxHistory>是6，
            则只保存最近6个月的文件，删除之前的旧文件。注意，删除旧文件是，那些为了归档而创建的目录也会被删除-->
            <maxHistory>${maxHistory}</maxHistory>
        </rollingPolicy>
        <!--        <encoder class="ch.qos.logback.core.encoder.LayoutWrappingEncoder">-->
        <!--            <layout class="com.geostar.common.log.logback.LogLayout" />-->
        <!--        </encoder>-->
        <!-- 按照固定窗口模式生成日志文件，当文件大于20MB时，生成新的日志文件。窗口大小是1到3，当保存了3个归档文件后，将覆盖最早的日志。
        <rollingPolicy class="ch.qos.logback.core.rolling.FixedWindowRollingPolicy">
          <fileNamePattern>${logPath}/%d{yyyy-MM-dd}/.log.zip</fileNamePattern>
          <minIndex>1</minIndex>
          <maxIndex>3</maxIndex>
        </rollingPolicy>   -->
        <!-- 查看当前活动文件的大小，如果超过指定大小会告知RollingFileAppender 触发当前活动文件滚动
        <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
            <maxFileSize>5MB</maxFileSize>
        </triggeringPolicy>   -->
    </appender>
    <!-- 特殊记录Error日志 -->
    <appender name="fileErrorLog" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!-- 只记录ERROR级别日志，添加范围过滤，可以将该类型的日志特殊记录到某个位置 -->
        <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
            <level>ERROR</level>
        </filter>
        <encoder>
            <pattern>%date %level [%thread] %logger [%file:%line] %msg%n</pattern>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${logPath}/error/%d.log</fileNamePattern>
            <!-- 日志最大的历史 60天 -->
            <maxHistory>60</maxHistory>
        </rollingPolicy>
        <!--        <encoder class="ch.qos.logback.core.encoder.LayoutWrappingEncoder">-->
        <!--            <layout class="com.geostar.common.log.logback.LogLayout" />-->
        <!--        </encoder>-->
    </appender>

    <!--    &lt;!&ndash;日志异步到数据库 &ndash;&gt;-->
    <!--    &lt;!&ndash; 数据库日志记录 &ndash;&gt;-->
    <!--    <appender name="DB_APPENDER" class="com.geostar.usersystem.log.LogDBAppender">-->
    <!--        　　-->
    <!--        <filter class="com.geostar.usersystem.log.LogbackMarkerFilter">-->
    <!--            &lt;!&ndash; 自定义标志 &ndash;&gt;-->
    <!--            　　　-->
    <!--            <marker>DB</marker>-->
    <!--            　　　-->
    <!--            <onMatch>ACCEPT</onMatch>-->
    <!--            　　　-->
    <!--            <onMismatch>DENY</onMismatch>-->
    <!--        </filter>-->
    <!--        &lt;!&ndash; 配置数据源 springboot默认情况会开启光连接池 &ndash;&gt;-->
    <!--        <connectionSource class="ch.qos.logback.core.db.DriverManagerConnectionSource">-->
    <!--            <driverClass>com.mysql.cj.jdbc.Driver</driverClass>-->
    <!--            <url>jdbc:mysql://127.0.0.1:3306/ceshi?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8&amp;serverTimezone=UTC</url>-->
    <!--            <user>root</user>-->
    <!--            <password>123456</password>-->
    <!--        </connectionSource>-->
    <!--    </appender>-->
    <!-- 异步输出 -->
    <appender name="ASYNC-INFO" class="ch.qos.logback.classic.AsyncAppender">
        <!-- 不丢失日志.默认的,如果队列的80%已满,则会丢弃TRACT、DEBUG、INFO级别的日志 -->
        <discardingThreshold>0</discardingThreshold>
        <!-- 更改默认的队列的深度,该值会影响性能.默认值为256 -->
        <queueSize>256</queueSize>
        <!-- 添加附加的appender,最多只能添加一个 -->
        <appender-ref ref="fileInfoLog"/>
    </appender>
    <appender name="ASYNC-ERROR" class="ch.qos.logback.classic.AsyncAppender">
        <!-- 不丢失日志.默认的,如果队列的80%已满,则会丢弃TRACT、DEBUG、INFO级别的日志 -->
        <discardingThreshold>0</discardingThreshold>
        <!-- 更改默认的队列的深度,该值会影响性能.默认值为256 -->
        <queueSize>256</queueSize>
        <!-- 添加附加的appender,最多只能添加一个 -->
        <appender-ref ref="fileErrorLog"/>
    </appender>

    <!-- 根节点，表名基本的日志级别，里面可以由多个appender规则 -->
    <!-- level="info"代表基础日志级别为info -->
    <root level="info">
        <!-- 引入控制台输出规则 -->
        <appender-ref ref="consoleLog"/>

        <appender-ref ref="ASYNC-INFO"/>
        <appender-ref ref="ASYNC-ERROR"/>
    </root>

    <!-- 不同包，设置不同的日志级别 -->
    <logger name="com.cn.geostar.md.harvest" level="debug"/>
    <logger name="java.sql.PreparedStatement" level="info"/>
</configuration>
```
