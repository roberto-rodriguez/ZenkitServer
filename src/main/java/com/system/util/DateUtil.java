/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.util;

import com.system.dto.request.Hash;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author roberto.rodriguez
 */
public class DateUtil {

    public static final Hash FORMATS = new Hash(
            "/", new SimpleDateFormat("MM/dd/yyyy"),
            "-", new SimpleDateFormat("MM-dd-yyyy"),
            "dmy", new SimpleDateFormat("dd/MM/yyyy")
    );

    public static String format(Date date) {
        return format(date, "-");
    }

    public static String format(Date date, String delimeter) {
        DateFormat format = (DateFormat) FORMATS.get(delimeter);
        return format.format(date);
    }

    public static Date addDays(Date date, Integer days) {
        Calendar C = Calendar.getInstance();
        C.setTime(date);
        C.add(Calendar.DATE, days);
        return C.getTime();
    }

    public static String formatMinutes(Integer mins) {
        if (mins != null) {
            int percent = mins % 60;
            String formattedPercent = (percent < 10) ? "0" + percent : percent + "";

            return mins / 60 + ":" + formattedPercent;
        }
        return "";
    }

    public static Integer daysBetween(Date date1, Date date2) {
        Long daysBetween = TimeUnit.DAYS.convert(date2.getTime() - date1.getTime(), TimeUnit.MILLISECONDS);
        return daysBetween.intValue();
    }
}
