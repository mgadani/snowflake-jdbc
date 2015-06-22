package com.placeiq.mg.snowflake;

import com.placeiq.mg.snowflake.config.AppConfig;
import com.placeiq.mg.snowflake.dao.LocationFeaturesDao;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.inject.Inject;

/**
 * Created by miralgadani on 5/29/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@ActiveProfiles("live")
@TransactionConfiguration
public class SnowflakeJdbcIntegrationTest {

    @Inject
    LocationFeaturesDao dao;

    @Ignore
    public void testCount() throws Exception {
        System.out.println(dao.count());
    }

    @Test
    public void testFindOne() throws Exception {
        System.out.println(dao.findOne("481130190382033"));
    }
}
