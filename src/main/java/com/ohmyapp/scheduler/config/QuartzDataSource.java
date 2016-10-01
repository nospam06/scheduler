package com.ohmyapp.scheduler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by Emerald on 9/26/2016.
 * quartz data source
 */
@Configuration
public class QuartzDataSource {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:mysql://localhost/test");
        ds.setUsername("test");
        ds.setPassword("test");
        return ds;
    }
}
