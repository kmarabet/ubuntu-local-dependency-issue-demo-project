package com.demo;

import org.apache.commons.lang.RandomStringUtils;
import java.util.UUID;

public class CommonUtils {

    private static final int NAME_LENGTH = 16;
    private static final String NAME_PREFIX = "tmp_";

    public static String generateUniqueDatabaseName(){
        return NAME_PREFIX + RandomStringUtils.randomAlphanumeric(NAME_LENGTH);
    }

    public static String generateUniqueQueueName(){
        return UUID.randomUUID().toString();
    }

}
