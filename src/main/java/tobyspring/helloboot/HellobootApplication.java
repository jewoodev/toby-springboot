package tobyspring.helloboot;

import org.springframework.boot.SpringApplication;
import tobyspring.infraconfig.MySpringBootApplication;

@MySpringBootApplication
public class HellobootApplication {
    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }
}
