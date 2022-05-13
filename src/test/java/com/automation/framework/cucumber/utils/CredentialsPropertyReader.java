package com.automation.framework.cucumber.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CredentialsPropertyReader {
    private static final String filepath = "src/test/resources/credentials.properties";
    private static HashMap<String, String> propertyMap;

    public static String getPropValue(String name) {
        if (null == propertyMap) {
            init();
        }
        String value = propertyMap.get(name);
        if (null == value || value.equals("")) {
            throw new IllegalStateException(name + " is not defined in config.properties file.");
        } else
            return value.trim();
    }


    public static String getEmailId() {
        if (null == propertyMap.get("emailid")) {
            throw new IllegalStateException("EmailId is not set in config.properties.");
        } else {
            return getPropValue("emailid");
        }
    }

    public static String getUserName() {
        if (null == getPropValue("username")) {
            throw new IllegalStateException("UserName is not set in config.properties.");
        } else {
            return getPropValue("username");
        }
    }

    public static void init() {
        File infile = new File(filepath);
        Properties prop = new Properties();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(infile), "UTF-8"));
            prop.load(br);
        } catch (IOException e) {
            Log.error(e.toString());
        }
        propertyMap = new HashMap<String, String>((Map) prop);
    }

    public static void main(String[] args) {
        init();
        for (Map.Entry<String, String> entry : CredentialsPropertyReader.propertyMap.entrySet()) {
            System.out.printf("Key : %s -- Value: %s %n", entry.getKey(), entry.getValue());
        }
    }
}
