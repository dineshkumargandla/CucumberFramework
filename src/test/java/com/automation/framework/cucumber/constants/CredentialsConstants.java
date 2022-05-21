package com.automation.framework.cucumber.constants;

import com.automation.framework.cucumber.utils.CredentialsPropertyReader;

public interface CredentialsConstants {

    public String USER_NAME = CredentialsPropertyReader.getUserName();

    public String EMAIL_ID = CredentialsPropertyReader.getEmailId();

    public  String VALID_PASSWORD = "MyPassword";

    public String INVALID_PASSWORD = "InValid_MyPassword";
    public  String REGISTERED_USER_NAME = "REGISTEREDUSERNAME";

    public String REGISTERED_EMAIL_ADDRESS = "REGISTEREDUSERNAME@test.com";


}
