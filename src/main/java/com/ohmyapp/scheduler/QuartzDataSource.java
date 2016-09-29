package com.ohmyapp.scheduler;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Emerald on 9/26/2016.
 * quartz data source
 */
@Configuration
public class QuartzDataSource {
    @Bean
    public DataSource dataSource() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL("jdbc:mysql://localhost/test");
        ds.setCreateDatabaseIfNotExist(true);
        ds.setUser("test");
        ds.setPassword("test");
        return ds;
    }
}
