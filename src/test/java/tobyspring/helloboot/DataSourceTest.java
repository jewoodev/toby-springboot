package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.SQLException;

@TestPropertySource("classpath:/application.properties")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HellobootApplication.class)
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
