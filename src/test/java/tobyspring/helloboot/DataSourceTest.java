package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@JdbcTest
class DataSourceTest {
    @Autowired
    private DataSource dataSource;

    @Test
    void connect() throws SQLException {
        var con = dataSource.getConnection();
        con.close();
    }
}
