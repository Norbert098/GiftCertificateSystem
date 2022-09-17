package com.epam.core.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Class responsible for connection with DB, through Hikari
 */

@Configuration
@ComponentScan("com.epam")
@EnableTransactionManagement
public class DaoConfig {

    @Component
    @PropertySource("classpath:db.properties")
    @Data
    public static class DBProperties {
        @Value("${jdbc.driver}")
        private String jdbcDriver;
        @Value("${jdbc.username}")
        private String jdbcUserName;
        @Value("${jdbc.url}")
        private String jdbcUrl;
        @Value("${jdbc.password}")
        private String jdbcPassword;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfiguration() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource(DBProperties dbProperties) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbProperties.getJdbcUrl());
        config.setUsername(dbProperties.getJdbcUserName());
        config.setPassword(dbProperties.getJdbcPassword());
        config.setDriverClassName(dbProperties.getJdbcDriver());
        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DBProperties dbProperties) {
        return new JdbcTemplate(dataSource(dbProperties));
    }
}
