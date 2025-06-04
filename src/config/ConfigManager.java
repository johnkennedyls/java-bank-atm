package config;

import java.util.Properties;

public class ConfigManager {
    private static ConfigManager instance;
    private Properties configProperties;

    private ConfigManager() {
        configProperties = new Properties();
        // Load configuration properties
        try {
            configProperties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception, e.g., log it or rethrow it
            throw new RuntimeException("Failed to load configuration properties", e);
        }
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) {
                    instance = new ConfigManager();
                }
            }
        }
        return instance;
    }

    public String getProperty(String key) {
        return configProperties.getProperty(key);
    }
}

