package com.automation.framework.cucumber.constants;

import com.automation.framework.cucumber.utils.CredentialsPropertyReader;
import org.testng.Assert;

public interface CredentialsConstants {
     static String USER_NAME = CredentialsPropertyReader.getUserName();
     static String EMAIL_ID = CredentialsPropertyReader.getEmailId();

     static String VALID_PASSWORD = "MyPassword";

     static String INVALID_PASSWORD = "InValid_MyPassword";
     static String REGISTERED_USER_NAME = "REGISTEREDUSERNAME";

     static String REGISTERED_EMAIL_ADDRESS = "REGISTEREDUSERNAME@test.com";

}
