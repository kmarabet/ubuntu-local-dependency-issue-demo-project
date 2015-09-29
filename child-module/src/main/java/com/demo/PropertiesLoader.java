package com.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader {

    // Constants ----------------------------------------------------------------------------------
    private final Properties PROPERTIES = new Properties();

    // Vars ---------------------------------------------------------------------------------------
    private String specificKey;
    private Map<String, String> envVarMap;
    private String PROPERTIES_FILE;

    // Constructors -------------------------------------------------------------------------------
    /**
     * Construct a DAOProperties instance for the given specific key which is to be used as property
     * key prefix of the DAO properties file.
     * @param specificKey The specific key which is to be used as property key prefix.
     * missing in the classpath or cannot be loaded.
     */
    public PropertiesLoader(final String propertiesFilePath, final String specificKey, final Map<String, String> env)  {
        this.specificKey = specificKey;
        this.envVarMap = env;
        loadPropertiesFile(propertiesFilePath);
    }

    /***
     *
     * @param propertiesFilePath the path relative to the jar app file
     */
    private void loadPropertiesFile(final String propertiesFilePath){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream(propertiesFilePath);

        if (propertiesFile == null) {
            System.out.println("Properties file '" + propertiesFilePath + "' is missing in classpath.");
            System.out.println("Trying to load it from the directory where the jar is deployed....");
            try {
                propertiesFile = new FileInputStream(propertiesFilePath);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(
                        "Properties file '" + propertiesFilePath + "' is missing in classpath.");
            }
        }

        try {
            PROPERTIES.load(propertiesFile);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Cannot load properties file '" + propertiesFilePath + "'.", e);
        }
    }

    // Actions ------------------------------------------------------------------------------------

    /**
     * Returns the DAOProperties instance specific property value associated with the given key with
     * the option to indicate whether the property is mandatory or not.
     * @param key The key to be associated with a DAOProperties instance specific value.
     * @param mandatory Sets whether the returned property value should not be null nor empty.
     * @return The DAOProperties instance specific property value associated with the given key.
     * it is mandatory.
     */
    public String getProperty(String key, boolean mandatory) {
        String fullKey = (specificKey == null || specificKey.trim().isEmpty()) ? key : specificKey + "_" + key;
        String property = envVarMap != null ? envVarMap.get(fullKey) : null;
        if (property == null) property = PROPERTIES.getProperty(fullKey);

        if (property == null || property.trim().length() == 0) {
            if (mandatory) {
                throw new RuntimeException("Required property '" + fullKey + "'"
                        + " is missing in properties file '" + PROPERTIES_FILE + "'.");
            } else {
                // Make empty value null. Empty Strings are evil.
                property = null;
            }
        }
        return property;
    }

}
