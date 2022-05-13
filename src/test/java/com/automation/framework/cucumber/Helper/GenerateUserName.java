package com.automation.framework.cucumber.Helper;


import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GenerateUserName {

    public static void createRandomUserName() throws IOException {

        int length = 8;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers).toLowerCase();
        FileInputStream in = new FileInputStream("src/test/resources/credentials.properties");
        Properties props = new Properties();
        props.load(in);
        in.close();

        FileOutputStream out = new FileOutputStream("src/test/resources/credentials.properties");
        props.setProperty("emailid", generatedString + "@gmail.com");
        props.setProperty("username", generatedString);
        props.store(out, null);
        out.close();
    }
}
