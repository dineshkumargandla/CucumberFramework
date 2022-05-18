package com.automation.framework.cucumber.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
            throw new IllegalStateException(name + " is not defined in config.properties file.");
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
        if (null == getPropValue("datafile.dir")) {
            Log.error("Input Data directory is not set in config.properties. ");
            throw new IllegalStateException("Input Data directory is not set in config.properties.");
        } else {
            return getPropValue("datafile.dir");
        }
    }

    public static String getBrowserName() {
        if (null == getPropValue("test.browser")) {
            Log.error("Browser name is not set in config.properties.");
            throw new IllegalStateException("Browser name is not set in config.properties.");
        } else {
            return getPropValue("test.browser");
        }
    }

    public static String getTimeout() {
        if (null == getPropValue("timeout")) {
            Log.error("Timeout is not set in config.properties.");
            throw new IllegalStateException("Timeout is not set in config.properties.");
        } else {
            return getPropValue("timeout");
        }
    }

    public static String getProductName() {
        if (null == getPropValue("product.name")) {
            Log.error("Product Name is not set in config.properties.");
            throw new IllegalStateException("Timeout is not set in config.properties.");
        } else {
            return getPropValue("product.name");
        }
    }

    public static String getProductVersion() {
        if (null == getPropValue("product.version")) {
            Log.error("Product version is not set in config.properties.");
            throw new IllegalStateException("Timeout is not set in config.properties.");
        } else {
            return getPropValue("product.version");
        }
    }


    public static String getProductBuild() {
        if (null == getPropValue("product.build")) {
            Log.error("Product Build is not set in config.properties.");
            throw new IllegalStateException("Product Build is not set in config.properties.");
        } else {
            return getPropValue("product.build");
        }
    }

    public static String getTakeShootsOnFailure() {
        if (null == getPropValue("take.screenshot.on.failure")) {
            Log.error("Take screenshot on failure is not set in config.properties.");
            throw new IllegalStateException("Take screenshot on failure is not set in config.properties.");
        } else {
            return getPropValue("take.screenshot.on.failure");
        }
    }

    public static String getDriverPath() {
        if (null == getPropValue("driver.path")) {
            Log.error("Driver path is not set in config.properties. ");
            throw new IllegalStateException("Driver path is not set in config.properties.");
        } else {
            return getPropValue("driver.path");
        }
    }

    public static String getApplicationUrl() {
        if (null == getPropValue("app.url")) {
            Log.error("Application URL is not set in config.properties. ");
            throw new IllegalStateException("Application  URL is not set in config.properties.");
        } else {
            return getPropValue("app.url");
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

    public static void main(String[] args)  {
        init();
        for (Map.Entry<String, String> entry : ConfigurationPropertyReader.propertyMap.entrySet()) {
            System.out.printf("Key : %s -- Value: %s %n", entry.getKey(), entry.getValue());
        }
    }
}
