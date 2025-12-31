package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HelloServiceCountTest {
    @Autowired
    private HelloService helloService;

    @Autowired
    private HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount() {
        IntStream.range(1, 10).forEach(count -> {
            helloService.sayHello("Spring");

            assertThat(helloRepository.countOf("Spring")).isEqualTo(count);
        });

    }
}
