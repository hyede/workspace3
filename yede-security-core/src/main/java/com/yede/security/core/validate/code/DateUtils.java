
package com.yede.security.core.validate.code;

import org.joda.time.DateTime;

import java.util.Date;

public class DateUtils {
    public DateUtils() {
    }

    public static boolean after(Date date1, Date date2) {
        return date1.after(date2);
    }

    public static boolean before(Date date1, Date date2) {
        return date1.before(date2);
    }

    public static Date plusYears(Date date, int year) {
        return (new DateTime(date)).plusYears(year).toDate();
    }

    public static Date plusMonths(Date date, int months) {
        return (new DateTime(date)).plusMonths(months).toDate();
    }

    public static Date plusWeeks(Date date, int weeks) {
        return (new DateTime(date)).plusWeeks(weeks).toDate();
    }

    public static Date plusDays(Date date, int days) {
        return (new DateTime(date)).plusDays(days).toDate();
    }

    public static Date plusHours(Date date, int hours) {
        return (new DateTime(date)).plusHours(hours).toDate();
    }

    public static Date plusMinutes(Date date, int minutes) {
        return (new DateTime(date)).plusMinutes(minutes).toDate();
    }

    public static Date plusSeconds(Date date, int seconds) {
        return (new DateTime(date)).plusSeconds(seconds).toDate();
    }

    public static Date plusMilliSeconds(Date date, int milliSeconds) {
        return (new DateTime(date)).plusMillis(milliSeconds).toDate();
    }

    public static Date minusYears(Date date, int years) {
        return (new DateTime(date)).minusYears(years).toDate();
    }

    public static Date minusMonths(Date date, int months) {
        return (new DateTime(date)).minusMonths(months).toDate();
    }

    public static Date minusWeeks(Date date, int weeks) {
        return (new DateTime(date)).minusWeeks(weeks).toDate();
    }

    public static Date minusDays(Date date, int days) {
        return (new DateTime(date)).minusDays(days).toDate();
    }

    public static Date minusHours(Date date, int hours) {
        return (new DateTime(date)).minusHours(hours).toDate();
    }

    public static Date minusMinutes(Date date, int minutes) {
        return (new DateTime(date)).minusMinutes(minutes).toDate();
    }

    public static Date minusSeconds(Date date, int seconds) {
        return (new DateTime(date)).minusSeconds(seconds).toDate();
    }
}
