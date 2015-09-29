package com.demo.db;

import com.demo.CommonUtils;
import com.demo.PropertiesLoader;

public class DatabaseSchemaHandler {

    private static final String PROPERTIES_FILE = "db_connection.properties";

    //Keys of properties
    //DataBase access params
    static final String DB_DRIVER_KEY = "db_driver";
    static final String DB_HOST_KEY = "db_host";
    static final String DB_PORT_KEY = "db_port";
    static final String DB_USER_KEY = "db_username";
    static final String DB_PASS_KEY = "db_password";
    //Main schema params
    static final String DB_MAIN_SCHEMA_NAME_KEY = "db_main_name";
    static final String DB_MAIN_SCHEMA_SCRIPT_LOCATION_KEY = "db_main_script_location";
    static final String DB_TABLES_SCRIPT_LOCATION_KEY = "db_tables_script_location";

    //Values of properties
    static final String JDBC_DRIVER;
    static final String DB_HOST;
    static final int DB_PORT;
    //static final String DB_URL = "jdbc:mysql://localhost:3307/";
    //static final String DB_URL = properties.getProperty("url", true);
    static final String DB_URL;
    static final String DB_USER;
    static final String DB_PASS;

    static final String DB_MAIN_NAME;
    static final String DB_MAIN_SCRIPT_LOCATION;
    static final String DB_TABLES_SCRIPT_LOCATION;


    static{
        final PropertiesLoader properties = new PropertiesLoader(PROPERTIES_FILE, null, System.getenv());
        JDBC_DRIVER = properties.getProperty(DB_DRIVER_KEY, true);
        DB_HOST = properties.getProperty(DB_HOST_KEY, true);
        DB_PORT = Integer.valueOf(properties.getProperty(DB_PORT_KEY, true));
        DB_URL = DatabaseUtils.getJdbcUrl(DB_HOST, DB_PORT);
        DB_USER = properties.getProperty(DB_USER_KEY, true);
        DB_PASS = properties.getProperty(DB_PASS_KEY, true);

        DB_MAIN_NAME = properties.getProperty(DB_MAIN_SCHEMA_NAME_KEY, true);
        DB_MAIN_SCRIPT_LOCATION = properties.getProperty(DB_MAIN_SCHEMA_SCRIPT_LOCATION_KEY, true);
        DB_TABLES_SCRIPT_LOCATION = properties.getProperty(DB_TABLES_SCRIPT_LOCATION_KEY, true);
    }

    public static void main(String[] args)  {

        System.out.println("Targeted DB URL: " + DB_URL);
        //logger.info("TESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSST");

        //final String DbSchemaName = UUID.randomUUID().toString();
        final String DbSchemaName = CommonUtils.generateUniqueDatabaseName();
        final String schemaUser = DB_USER + "_";
        final String schemaPass = DB_PASS + "_";


    }//end main



}//end JDBCTest