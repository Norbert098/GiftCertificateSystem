package com.epam.core.config;


import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Class needed for H2 embeded class ..
 */

@Configuration
@ComponentScan(basePackages = "com.epam.config")
public class ConnectionConfigurator {

    @Bean
    public DataSource dataSource() {
        EmbeddedPostgres postgres = null;
        try {
            postgres = EmbeddedPostgres.builder().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert postgres != null;
        return postgres.getPostgresDatabase();
    }
}
