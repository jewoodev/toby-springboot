package tobyspring.helloboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class HelloConfig {
    @Bean
    public HelloService helloService() {
        return new HelloDecorator(new SimpleHelloService());
    }
}
