package com.yq.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static Properties properties;
    private static ConfigManager configManager = new ConfigManager();

    private ConfigManager() {
        String configFile = "database.properties";
        properties = new Properties();
        InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
        try {
            properties.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigManager getInstance() {
//        if (configManager == null) {
//            configManager = new ConfigManager();
//        }
        return configManager;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
