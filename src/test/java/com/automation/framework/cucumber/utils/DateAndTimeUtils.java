package com.automation.framework.cucumber.utils;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateAndTimeUtils {

    public static LocalDate getCurrentDate(){
        return java.time.LocalDate.now();
    }

    public static  LocalTime getCurrentTime(){
        return java.time.LocalTime.now();
    }

}
