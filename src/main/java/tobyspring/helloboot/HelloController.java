package tobyspring.helloboot;

import java.util.Objects;

public class HelloController {
    public String hello(String name) {
        var helloService = new SimpleHelloService();
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
