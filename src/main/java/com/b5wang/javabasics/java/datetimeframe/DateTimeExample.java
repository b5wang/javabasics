package com.b5wang.javabasics.java.datetimeframe;

import java.time.*;
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
         * LocalDateTime has no timezone information
         */
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime           : " + localDateTime.toString());
        System.out.println("Local timezone id       : " + ZoneId.systemDefault().getId());
        System.out.println("Local timezone          : " + TimeZone.getDefault());
        System.out.println("--------------------------------------------------------------");
        System.out.println("ZonedDateTime:");
        /*
         * ZonedDateTime has no timezone information
         */
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        long nowMilliSecond = System.currentTimeMillis();
        System.out.println("zonedDateTime           : " + zonedDateTime.getZone().getId());
        System.out.println("zonedDateTime           : " + zonedDateTime.getZone());
        System.out.println("zonedDateTime           : " + zonedDateTime.toString());
        System.out.println("zonedDateTime epochMilli: " + zonedDateTime.toInstant().toEpochMilli());
        System.out.println("nowMilliSecond          : " + nowMilliSecond);

        // TimeZone switch
        System.out.println("--------------------------------------------------------------");
        System.out.println("Switch timezone         :");
        System.out.println("localDateTime           : " + localDateTime.toString() + " at " + ZoneId.systemDefault().getId());
        System.out.println("Australia/Sydney        : " + localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("Australia/Sydney")));
        System.out.println("Asia/Tokyo              : " + localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("Asia/Tokyo")));
        System.out.println("Asia/Singapore          : " + localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("Asia/Singapore")));
        System.out.println("Asia/Jakarta            : " + localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("Asia/Jakarta")));
        System.out.println("Europe/Rome             : " + localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("Europe/Rome")));
        System.out.println("Europe/Paris            : " + localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("Europe/Paris")));
        System.out.println("Europe/London           : " + localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("Europe/London")));
        System.out.println("UTC                     : " + localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")));
        System.out.println("US/Pacific              : " + localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("US/Pacific")));


        System.out.println("--------------------------------------------------------------");
        System.out.println("Switch time from Tokyo to Paris,");
        /**
         * There will be a meeting in Tokyo at 2025-6-18 14:30:00.
         * When the colleagues in Paris office should join the meeting remotely?
         * */
        LocalDateTime dateTimeOfTokyo = LocalDateTime.of(2025,6,18,14,30,0);
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        ZoneId parisZone = ZoneId.of("Europe/Paris");
        LocalDateTime dateTimeOfParis = dateTimeOfTokyo.atZone(tokyoZone).withZoneSameInstant(parisZone).toLocalDateTime();
        System.out.println("Tokyo local time        : " + dateTimeOfTokyo);
        System.out.println("To Paris local time     : " + dateTimeOfParis);

        ZonedDateTime tokyoDateTime = dateTimeOfTokyo.atZone(tokyoZone);
        ZonedDateTime parisDateTime = tokyoDateTime.withZoneSameInstant(parisZone);
        System.out.println("Tokyo zone time         : " + tokyoDateTime);
        System.out.println("To Paris zone time      : " + parisDateTime);

        System.out.println("--------------------------------------------------------------");
        System.out.println("ZoneOffset: A simpler and higher performance TimeZone switch way,");
        /**
         * ZoneOffset offset1 = ZoneOffset.of("+08:00"); // UTC+8
         * ZoneOffset offset2 = ZoneOffset.of("-05:00"); // UTC-5
         * ZoneOffset utc = ZoneOffset.UTC; // 等同于 "+00:00"
         * 1. 与ZoneId的区别：ZoneOffset更轻量，但无法处理夏令时
         * 2. 性能: ZoneOffset-更高（无时区规则计算）; ZoneId-较低（需处理时区规则）
         * 3. 典型用途: ZoneOffset-数据库存储、日志、简单时间计算; ZoneId-地区时间显示、跨时区业务逻辑
         * */
        ZoneOffset utcZoneOffset = ZoneOffset.UTC;
        ZoneOffset utc8ZoneOffset = ZoneOffset.ofHours(8);
        ZoneOffset utc7ZoneOffset = ZoneOffset.of("+07:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.now();// Similar as ZonedDateTime
        System.out.println("Offset time             : " + offsetDateTime);
        System.out.println("UTC+8 offset time       : " + offsetDateTime.withOffsetSameInstant(utc8ZoneOffset));
        System.out.println("UTC+7 offset time       : " + offsetDateTime.withOffsetSameInstant(utc7ZoneOffset));
        System.out.println("UTC   offset time       : " + offsetDateTime.withOffsetSameInstant(utcZoneOffset));
    }

}
