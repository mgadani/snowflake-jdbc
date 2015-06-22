package com.placeiq.mg.snowflake.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by miralgadani on 5/30/15.
 */
@Configuration
@Profile("live")
@PropertySource("classpath:prod-db.properties")
public class ProdConfig extends DbConfig {

}
