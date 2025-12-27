package tobyspring.helloboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloServiceTest {
    @Test
    void simpleHelloService() {
        var helloService = new SimpleHelloService();

        String ret = helloService.sayHello("Spring");
        assertThat(ret).isEqualTo("Hello Spring");
    }
}

