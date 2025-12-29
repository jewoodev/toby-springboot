package tobyspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.helloboot.HelloDecorator;
import tobyspring.helloboot.HelloService;
import tobyspring.helloboot.SimpleHelloService;

@Configuration
public class HelloConfig {
    @Bean
    public HelloService helloService() {
        return new HelloDecorator(new SimpleHelloService());
    }
}
