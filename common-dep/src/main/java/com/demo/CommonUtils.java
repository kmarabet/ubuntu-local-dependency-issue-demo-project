package com.demo;

import org.apache.commons.lang.RandomStringUtils;
import java.util.UUID;
import org.springframework.core.env.Environment;

public class CommonUtils {

    private static final int NAME_LENGTH = 16;
    private static final String NAME_PREFIX = "tmp_";

    public static String generateUniqueDatabaseName(){
        return NAME_PREFIX + RandomStringUtils.randomAlphanumeric(NAME_LENGTH);
    }

    public static String generateUniqueQueueName(){
        return UUID.randomUUID().toString();
    }

    private String getProperty(final String name, final boolean required, Environment environment) {
        if (required)
            return System.getenv(name) != null ? System.getenv(name) : environment.getRequiredProperty(name);
        else
            return System.getenv(name) != null ? System.getenv(name) : environment.getProperty(name);
    }

}
