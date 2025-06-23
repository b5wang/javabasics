package com.b5wang.javabasics.java.datetimeframe;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.TimeZone;

public class DateTimeExample {

    public static void main(String[] args) {

        /*
         * 1. Instant.now().toEpochMilli() == System.currentTimeMillis()
         * 2. In different time zones, the millis are all the same values.
         * 3. milliseconds time difference between current time and Etc/GMT or Etc/UTC 1970-01-01 00:00:00.000
         * */
        System.out.println("--------------------------------------------------------------");
        System.out.println("New Instant and old System.currentTimeMillis():");
        Instant nowInstant = Instant.now();
        long toEpochMilli = nowInstant.toEpochMilli();
        long currentTimeMillis = System.currentTimeMillis();
        long toEpochMilliGMT = nowInstant.atZone(ZoneId.of("Etc/GMT")).toInstant().toEpochMilli();
        long toEpochMilliGMT8 = nowInstant.atZone(ZoneId.of("Etc/GMT+8")).toInstant().toEpochMilli();
        System.out.println("Instant toEpochMilli    : " + toEpochMilli);
        System.out.println("System currentTimeMillis: " + currentTimeMillis);
        System.out.println("Instant GMT             : " + toEpochMilliGMT);
        System.out.println("Instant GMT+8           : " + toEpochMilliGMT8);

        System.out.println("--------------------------------------------------------------");
        System.out.println("Instant:");
        /*
         * Instant is milliseconds of UTC, or Etc/GMT, or Etc/UTC. Instant does not have TimeZone information
         */
        Instant instant = Instant.now();
        System.out.println("instant                 : " + instant.toEpochMilli());
        System.out.println("instant                 : " + instant.toString());
        System.out.println("instant(defaultTimeZone): " + instant.atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli());
        System.out.println("instant(defaultTimeZone): " + instant.atZone(TimeZone.getDefault().toZoneId()).toString());
        /*
         * Etc/GMT-8 == GMT+8
         */
        System.out.println("instant(Etc/GMT-8)      : " + instant.atZone(ZoneId.of("Etc/GMT-8")).toInstant().toEpochMilli());
        System.out.println("instant(Etc/GMT-8)      : " + instant.atZone(ZoneId.of("Etc/GMT-8")).toString());
        System.out.println("instant(GMT+8)          : " + instant.atZone(ZoneId.of("GMT+8")).toInstant().toEpochMilli());
        System.out.println("instant(GMT+8)          : " + instant.atZone(ZoneId.of("GMT+8")).toString());
        System.out.println("instant(Etc/GMT+8)      : " + instant.atZone(ZoneId.of("Etc/GMT+8")).toInstant().toEpochMilli());
        System.out.println("instant(Etc/GMT+8)      : " + instant.atZone(ZoneId.of("Etc/GMT+8")).toString());

        System.out.println("--------------------------------------------------------------");
        System.out.println("LocalDateTime:");
        /*
         *LocalDateTime has no timezone information
         */
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime           : " + localDateTime.toString());

        // ZoneDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime           : " + zonedDateTime.getZone());
        System.out.println("zonedDateTime           : " + zonedDateTime.toString());
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
