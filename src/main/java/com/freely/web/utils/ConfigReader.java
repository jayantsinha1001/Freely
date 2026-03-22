package com.freely.web.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties file not found!");
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static String getUrl(String key, String path) {
        String specificUrl = properties.getProperty(key);
        if (specificUrl != null && !specificUrl.trim().isEmpty()) {
            return specificUrl;
        }
        return getBaseUrl() + path;
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }

    public static int getImplicitWait() {
        return Integer.parseInt(properties.getProperty("implicit.wait"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(properties.getProperty("explicit.wait"));
    }

    public static int getPageLoadTimeout() {
        return Integer.parseInt(properties.getProperty("page.load.timeout"));
    }


}
