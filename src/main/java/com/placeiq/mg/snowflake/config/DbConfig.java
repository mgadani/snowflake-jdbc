package com.placeiq.mg.snowflake.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

/**
 * Created by miralgadani on 5/30/15.
 */
@Configuration
public class DbConfig {
    @Value("${db.driver}")
    private String driverClassName;

    @Value("${db.url}")
    private String dbUrl;

    @Value("#{'${db.props}'.split(',')}")
    private List<String> dbProps;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(dbUrl);
        dataSource.setConnectionProperties(parseProperties(dbProps));
        return dataSource;
    }

    protected Properties parseProperties(List<String> dbProps) {
        Properties props = new Properties();
        for(String kv : dbProps) {
            String[] split = kv.split(":");
            if(split.length == 2) {
                props.put(split[0], split[1]);
            } else if(split.length == 1)  {
                props.put(split[0], "");
            }
        }

        return props;
    }

    @Bean
    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return new NamedParameterJdbcTemplate(getDataSource());
    }
}
