package com.stl.freezer.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;


/**
 * Created by Sebastian Thümmel on 01.09.2017.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.stl.freezer")
@Slf4j
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/freezer");
        log.debug("User: " +System.getenv("dbuser") +" : "+ System.getenv("dbpassword"));
        dataSource.setUsername(System.getenv("dbuser"));
        dataSource.setPassword(System.getenv("dbpassword"));
        return dataSource;
    }


}

    