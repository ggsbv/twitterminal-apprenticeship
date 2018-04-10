package com.codurance.twitterminal;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimestampFormatter {
    private static final String SECOND = "second";
    private static final String MINUTE = "minute";
    private static final String HOUR = "hour";
    private static final String TIMESTAMP_TEMPLATE = "%d %s ago";
    private static final String  DAY = "day";

    public String formatTimeAgo(LocalDateTime date) {
        LocalDateTime now = LocalDateTime.now();

        long dateDifferenceInDays = date.until(now, ChronoUnit.DAYS);

        if (dateDifferenceInDays > 0) {
            if (dateDifferenceInDays > 1) return format(dateDifferenceInDays, DAY);

            return format(dateDifferenceInDays, DAY+"s");
        }

        long dateDifferenceInHours = date.until(now, ChronoUnit.HOURS);

        if (dateDifferenceInHours > 0) {
            if (dateDifferenceInHours > 1) return String.format(TIMESTAMP_TEMPLATE, dateDifferenceInHours, HOUR + "s");

            return String.format(TIMESTAMP_TEMPLATE, dateDifferenceInHours, HOUR);
        }

        long dateDifferenceInMinutes = date.until(now, ChronoUnit.MINUTES);

        if (dateDifferenceInMinutes > 0) {
            if (dateDifferenceInMinutes > 1) return String.format(TIMESTAMP_TEMPLATE, dateDifferenceInMinutes, MINUTE + "s");

            return String.format(TIMESTAMP_TEMPLATE, dateDifferenceInMinutes, MINUTE);
        }

        long dateDifferenceInSeconds = date.until(now, ChronoUnit.SECONDS);
        if (dateDifferenceInSeconds > 1) return String.format(TIMESTAMP_TEMPLATE, dateDifferenceInSeconds, SECOND + "s");

        return String.format(TIMESTAMP_TEMPLATE, dateDifferenceInSeconds, SECOND);
    }

    private String format(long timeInUnits, String timeUnit) {
        return String.format(TIMESTAMP_TEMPLATE, timeInUnits, timeUnit);
    }
}
