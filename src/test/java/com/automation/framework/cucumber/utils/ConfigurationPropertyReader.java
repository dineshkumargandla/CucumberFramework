package com.automation.framework.cucumber.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ConfigurationPropertyReader {

    private static final String filepath = "src/test/resources/config.properties";
    private static HashMap<String, String> propertyMap;

    public static String getPropValue(String name) {
        if (null == propertyMap) {
            init();
        }
        String value = propertyMap.get(name);
        if (null == value || value.equals("")) {
            Log.error(name + " is not defined in config.properties file.");
            return "";
        } else
            return value.trim();
    }

    public static String getScreenOutDir() {
        if (getPropValue("screen.outdir").equals("")) {
            StringBuilder sb = new StringBuilder(System.getProperty("user.dir"));
            sb.setLength(sb.indexOf(String.valueOf(File.separatorChar)) + 1);
            sb.append("screens");
            Log.info("Output directory is not set in config.properties and set to " + sb.toString());
            return sb.toString();
        } else {
            return getPropValue("screen.outdir");
        }
    }

    public static String getDataDir() {
        if (null == propertyMap.get("datafile.dir")) {
            Log.error("Input Data directory is not set in config.properties. ");
            return "data";
        } else {
            return getPropValue("datafile.dir");
        }
    }

    public static String getBrowserName() {
        if (null == getPropValue("test.browser")) {
            Log.error("Input Data directory is not set in config.properties. ");
            return "data";
        } else {
            return getPropValue("test.browser");
        }
    }

    public static String getDriverPath() {
        if (null == getPropValue("driver.path")) {
            Log.error("Input Data directory is not set in config.properties. ");
            return "data";
        } else {
            return getPropValue("driver.path");
        }
    }

    public static String getApplicationUrl() {
        if (null == propertyMap.get("app.url")) {
            Log.error("Input Data directory is not set in config.properties. ");
            return "data";
        } else {
            return getPropValue("app.url");
        }
    }

    public static String getFeatureFileLocation() {
        if (null == propertyMap.get("featurefile.location")) {
            Log.error("Input Data directory is not set in config.properties. ");
            return "data";
        } else {
            return getPropValue("featurefile.location");
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

    public static void main(String[] args) throws FileNotFoundException {
        ConfigurationPropertyReader con = new ConfigurationPropertyReader();
        init();
        for (Map.Entry<String, String> entry : ConfigurationPropertyReader.propertyMap.entrySet()) {
            System.out.printf("Key : %s -- Value: %s %n", entry.getKey(), entry.getValue());
        }
    }
}
