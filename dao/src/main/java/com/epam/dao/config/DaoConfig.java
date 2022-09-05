package com.epam.dao.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.epam")
@EnableTransactionManagement
public class DaoConfig {

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
        return new JdbcTemplate(dataSource(dbProperties ));
    }
}
