package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class HelloRepositoryTest {
    @Autowired
    private HelloRepository helloRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void findHelloFailed() {
        assertThatThrownBy(() -> helloRepository.findHello("Jewoo"))
                .isInstanceOf(EmptyResultDataAccessException.class);
    }

    @Test
    void increaseCount() {
        String name = "Jewoo";
        assertThat(helloRepository.countOf(name)).isEqualTo(0);

        helloRepository.increaseCount(name);
        assertThat(helloRepository.countOf(name)).isEqualTo(1);

        helloRepository.increaseCount(name);
        assertThat(helloRepository.countOf(name)).isEqualTo(2);
    }
}