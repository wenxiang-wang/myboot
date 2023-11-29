package www.springboot.BaseApplication;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BaseApplication.class);
        application.setBannerMode(Banner.Mode.OFF);  // 关闭横幅
        application.run(args);
    }
}
