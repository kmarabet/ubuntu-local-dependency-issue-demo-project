package com.demo.db;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = DbTestConfig.class, loader = AnnotationConfigContextLoader.class)
public class DatabaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseTest.class);

    @Test
    public void testDbSchemaCreation() throws SQLException{
        LOGGER.info("Testing demo... ");

    }

}
