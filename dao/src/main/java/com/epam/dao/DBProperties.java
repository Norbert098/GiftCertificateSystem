package com.epam.dao;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:db.properties")
@Data
public class DBProperties {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    //@Value("${jdbc.username}")
    @Value("${System.getenv(PSusername)}")
    private String jdbcUserName;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    //@Value("${jdbc.password}")
    @Value("${System.getenv(PSpassword)}")
    private String jdbcPassword;
}
