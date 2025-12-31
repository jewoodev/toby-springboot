
package tobyspring.helloboot;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static org.assertj.core.api.Assertions.assertThat;

@Retention(RetentionPolicy.RUNTIME)
@UnitTest
@interface FastUnitTest {}


@Retention(RetentionPolicy.RUNTIME)
@Test
@interface UnitTest {}

class HelloServiceTest {
    @FastUnitTest
    void simpleHelloService() {
        var helloService = new SimpleHelloService(helloRepositoryStub);

        String ret = helloService.sayHello("Spring");
        assertThat(ret).isEqualTo("Hello Spring");
    }

    private static HelloRepository helloRepositoryStub = new HelloRepository() {
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public int increaseCount(String name) {
            return 0;
        }
    };

    @UnitTest
    void helloDecorator() {
        var decorator = new HelloDecorator(name -> name);

        String ret = decorator.sayHello("Spring");

        assertThat(ret).isEqualTo("* Spring *");
    }
}

