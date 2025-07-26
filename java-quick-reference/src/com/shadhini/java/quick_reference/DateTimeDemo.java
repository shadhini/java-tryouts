package com.shadhini.java.quick_reference;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {

    public static void main(String[] args) {
        // LocalDate: date (year, month, day) without time or timezone -------------------------------------------------
        System.out.println("LocalDate -------------------------------------------------------------------------------");
        LocalDate localDateToday = LocalDate.now();
        System.out.println(localDateToday); // e.g: 2025-07-26

        // LocalTime: time (hours, minutes, seconds, nanoseconds) without date or timezone -----------------------------
        System.out.println("LocalTime -------------------------------------------------------------------------------");
        LocalTime localTimeNow = LocalTime.now();
        System.out.println(localTimeNow); // e.g: 12:10:47.589417

        // LocalDateTime: both date and time, still without timezone ---------------------------------------------------
        System.out.println("LocalDateTime ---------------------------------------------------------------------------");
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        System.out.println(localDateTimeNow); // e.g: 2025-07-26T12:12:25.783115

        // ZonedDateTime: date and time with a timezone ----------------------------------------------------------------
        System.out.println("ZonedDateTime ---------------------------------------------------------------------------");
        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
        System.out.println(zonedDateTimeNow); // e.g: 2025-07-26T12:13:25.864628+05:30[Asia/Colombo]


        // Formatting and Parsing: using java.time.format.DateTimeFormatter --------------------------------------------
        System.out.println("Formatting and Parsing: using java.time.format.DateTimeFormatter ------------------------");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = now.format(formatter);
        System.out.println(formatted);

        // Parsing String to a Date
        String dateString = "2025-07-26 06:31:01";
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        System.out.println(dateTime);
    }
}
