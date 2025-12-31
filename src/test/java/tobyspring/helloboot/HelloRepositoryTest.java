package tobyspring.helloboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@HellobootTest
class HelloRepositoryTest {
    @Autowired
    private HelloRepository helloRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        jdbcTemplate.execute("create table if not exists hello (name varchar(50) primary key, count int)");
    }

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