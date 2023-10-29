package com.tuana9a.fileservlet.configs;

import lombok.ToString;

import java.util.Properties;

@ToString
public class AppConfig {
    public Properties properties;

    public String ROOT_FOLDER() {
        return properties.getProperty("ROOT_FOLDER");
    }

    public boolean SHOW_SQL = true;

    public int BUFFER_SIZE = 1024; // 1KB
    public long DEFAULT_EXPIRE_TIME = 604800000L; // 1 weeks
    public String MULTIPART_BOUNDARY = "MULTIPART_BYTERANGES";

    public String EXPLORER_PREFIX = "/explorer";

    private AppConfig() {

    }

    private static final AppConfig instance = new AppConfig();

    public static AppConfig getInstance() {
        return instance;
    }

    public void load() {
        properties = new Properties();
        properties.setProperty("ROOT_FOLDER", System.getenv("ROOT_FOLDER"));
    }
}
