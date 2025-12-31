package tobyspring.helloboot;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryJdbc implements HelloRepository {
    private final JdbcTemplate jdbcTemplate;

    public HelloRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Hello findHello(String name) {
        return jdbcTemplate.queryForObject("select * from hello where name = '" + name + "'", (rs, rowNum) -> new Hello(rs.getString("name"), rs.getInt("count")));
    }

    @Override
    public int increaseCount(String name) {
        Hello hello;
        try {
            hello = findHello(name);
        } catch (EmptyResultDataAccessException e) {
            jdbcTemplate.update("insert into hello values(?, ?)", name, 1);
            return 1;
        }
        jdbcTemplate.update("update hello set count = ? where name = ?", hello.getCount() + 1, name);
        return hello.getCount() + 1;
    }
}
