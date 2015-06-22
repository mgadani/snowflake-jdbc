package com.placeiq.mg.snowflake.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by miralgadani on 5/30/15.
 */
@Configuration
@Profile("test")
@PropertySource("classpath:test-db.properties")
public class TestConfig extends DbConfig {

}
