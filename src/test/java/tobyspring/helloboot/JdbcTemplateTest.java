package tobyspring.helloboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        jdbcTemplate.execute("create table if not exists hello (name varchar(50) primary key, count int)");
    }

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("insert into hello values(?, ?)", "Jewoo", 3);
        jdbcTemplate.update("insert into hello values(?, ?)", "Spring", 1);

        var count = jdbcTemplate.queryForObject("select count(*) from hello", Integer.class);
        assertThat(count).isNotNull().isEqualTo(2);
    }

    @Test
    void insertAndQuery2() {
        jdbcTemplate.update("insert into hello values(?, ?)", "Jewoo", 3);
        jdbcTemplate.update("insert into hello values(?, ?)", "Spring", 1);

        var count = jdbcTemplate.queryForObject("select count(*) from hello", Integer.class);
        assertThat(count).isNotNull().isEqualTo(2);
    }
}
