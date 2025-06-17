package com.b5wang.javabasics.java.datetimeframe;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class DateTimeExample {

    public static void main(String[] args) {

        // UTC+0
        Instant instant = Instant.now();
        System.out.println("instant: " + instant.toEpochMilli());
        System.out.println("instant: " + instant.toString());
        System.out.println("instant(atZone): " + instant.atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli());
        System.out.println("instant(atZone): " + instant.atZone(TimeZone.getDefault().toZoneId()).toString());

        // LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime: " + localDateTime.toString());

        // ZoneDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime: " + zonedDateTime.getZone());
        System.out.println("zonedDateTime: " + zonedDateTime.toString());
        System.out.println("zonedDateTime epochMilli: " + zonedDateTime.toInstant().toEpochMilli());

        // TimeZone switch
        System.out.println("localDateTime: " + localDateTime.toString());
        ZonedDateTime sgTime = localDateTime.atZone(TimeZone.getTimeZone("Asia/Singapore").toZoneId());
        System.out.println("sgTime: " + sgTime.toString() + " - " + sgTime.toInstant().toEpochMilli());
        ZonedDateTime indoTime = sgTime.toInstant().atZone(TimeZone.getTimeZone("Asia/Jakarta").toZoneId());
        System.out.println("indoTime: " + indoTime.toString() + " - " + indoTime.toInstant().toEpochMilli());

        // DateTiem format with time zone information
        ZoneId indoZoneId = ZoneId.of("Asia/Jakarta");
        ZoneOffset indoZoneOffset = LocalDateTime.now().atZone(indoZoneId).getOffset();
        System.out.println("indoZoneOffset: " + indoZoneOffset.toString());

        ZonedDateTime dateTime = ZonedDateTime.now(indoZoneId);
        System.out.println("dateTime: " + dateTime);

        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println("ldt: " + ldt);
        System.out.println("zdt: " + zdt);
        zdt = ldt.atZone(ZoneId.systemDefault());
        System.out.println("zdt: " + zdt);
    }

}
