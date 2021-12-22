package com.scharco.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRead {

    public Properties properties;

    public String readProperties(String proData) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./config.properties");
        properties = new Properties();
        properties.load(fileInputStream);
        return properties.getProperty(proData);
    }
}