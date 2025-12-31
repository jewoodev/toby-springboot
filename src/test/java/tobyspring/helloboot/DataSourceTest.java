package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.SQLException;

@HellobootTest
class DataSourceTest {
    @Autowired
    private DataSource dataSource;

    @Test
    void connect() throws SQLException {
        var con = dataSource.getConnection();
        con.close();
    }

    @Test
    void hikari() {

    }
}
