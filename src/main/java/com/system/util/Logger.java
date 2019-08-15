/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.util;

import com.system.enums.LogLevel;

/**
 *
 * @author roberto.rodriguez
 */
public class Logger {

    public static LogLevel logLevel = LogLevel.INFO;

    public static void info(String msg) {
        log(LogLevel.INFO, msg);
    }

    public static void debug(String msg) {
        log(LogLevel.DEBUG, msg);
    }

    public static void error(String msg) {
        log(LogLevel.ERROR, msg);
    }

    public static void exception(Exception e) {
        if (LogLevel.ERROR.get() <= logLevel.get()) {
            e.printStackTrace();
        }
    }

    private static void log(LogLevel level, String msg) {
        if (level.get() <= logLevel.get()) {
            System.out.println(msg);
        }
    }
}
