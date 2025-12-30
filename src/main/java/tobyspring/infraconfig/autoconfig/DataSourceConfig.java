package tobyspring.infraconfig.autoconfig;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import tobyspring.infraconfig.ConditionalMyOnClass;
import tobyspring.infraconfig.EnableMyConfigurationProperties;
import tobyspring.infraconfig.MyAutoConfiguration;

import javax.sql.DataSource;
import java.sql.Driver;

@MyAutoConfiguration
@EnableMyConfigurationProperties(MyDataSourceProperties.class)
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
public class DataSourceConfig {
    @Bean
    @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
    @ConditionalOnMissingBean
    public DataSource hikariDataSource(MyDataSourceProperties properties) {
        var dataSource = new HikariDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());

        return dataSource;
    }

    @Bean
    @ConditionalOnMissingBean
    public DataSource dataSource(MyDataSourceProperties properties) throws ClassNotFoundException {
        var dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(properties.getDriverClassName()));
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());

        return dataSource;
    }
}
