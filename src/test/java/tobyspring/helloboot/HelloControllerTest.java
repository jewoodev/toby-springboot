package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HelloControllerTest {
    @Test
    void helloController() {
        var helloController = new HelloController(name -> "Hello " + name);

        String ret = helloController.hello("Spring");

        assertThat(ret).isEqualTo("Hello Spring");
    }

    @Test
    void byeController() {
        var ret = new StringBuilder("Spring");
        var byeController = new ByeController(() -> ret.insert(0, "Bye "));
        byeController.bye();

        assertThat(ret.toString()).isEqualTo("Bye Spring");
    }

    @Test
    void failingHelloController() {
        var helloController = new HelloController(name -> "Hello " + name);

        assertThatThrownBy(() -> helloController.hello(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> helloController.hello("")).isInstanceOf(IllegalArgumentException.class);
    }
}
