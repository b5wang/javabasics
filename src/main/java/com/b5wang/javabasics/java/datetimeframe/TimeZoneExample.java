package com.b5wang.javabasics.java.datetimeframe;

import java.util.TimeZone;

public class TimeZoneExample {

    public static void main(String[] args) {
        String[] timeZoneIDs = TimeZone.getAvailableIDs();
        for(String timeZoneId: timeZoneIDs){
            System.out.println(timeZoneId + " - " + TimeZone.getTimeZone(timeZoneId).toString());
        }

        System.out.println("Default timeZone: " + TimeZone.getDefault());
    }

}
