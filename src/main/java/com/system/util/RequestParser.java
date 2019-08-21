/*
 ** File: WebResponse.java
 **
 ** Date Created: December 2016
 **
 ** Copyright @ 2016-2018 Roberto Rodriguez.
 ** Email: robertoSoftwareEngineer@gmail.com
 **
 ** All rights reserved. No part of this software may be 
 ** reproduced, transmitted, transcribed, stored in a retrieval 
 ** system, or translated into any language or computer language, 
 ** in any form or by any means, electronic, mechanical, magnetic, 
 ** optical, chemical, manual or otherwise, without the prior 
 ** written permission of Roberto Rodriguez.
 **
 */
package com.system.util;

import com.system.dto.request.Hash;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Criterion;

/**
 *
 * @author rrodriguez
 */
public class RequestParser {

    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    public static final String PARAMS_SEPARATOR = "@p@";//"@@";
    public static final String PARAMS_EQUAL = "@is@";

    public static List<Criterion> parseParamsToExpressions(String paramsStr) {
        List<Criterion> expressions = new ArrayList<>();

        if (paramsStr == null || "undefined".equals(paramsStr)) {
            return expressions;
        }
        paramsStr = paramsStr.replaceAll("%20", " ");

        if (paramsStr != null && !paramsStr.isEmpty()) {
            String[] prefixValues = paramsStr.split(PARAMS_SEPARATOR);

            for (String prefixValue : prefixValues) {
                if (prefixValue.length() > 0 && prefixValue.contains(PARAMS_EQUAL)) {
                    String[] kv = prefixValue.split(PARAMS_EQUAL);

                    String key = kv[0];
                    String value = kv[1];

                    Criterion expression = paramToExpression(key, value);

                    if (expression != null) {
                        expressions.add(expression);
                    }
                }
            }
        }
        return expressions;
    }

    private static Criterion paramToExpression(String key, String value) {
        Criterion criterion = null;

        try {
            String prefix = key;

            if (value.trim().startsWith("(") && value.contains(")")) {
                prefix = value.trim().substring(0, value.indexOf(")") + 1);
                value = value.trim().substring(value.indexOf(")") + 1);
            }

            if (value.isEmpty() || value.equalsIgnoreCase("null")) {
                return null;
            }

            switch (prefix) {
                case "(S)":
                    if (key.contains(",")) {
                        String[] keys = key.split(",");
                        Criterion[] subExpressions = new Criterion[keys.length];

                        for (int i = 0; i < keys.length; i++) {
                            subExpressions[i] = Restrictions.like(keys[i], value, MatchMode.ANYWHERE).ignoreCase();
                        }

                        criterion = Restrictions.or(subExpressions);
                    } else {
                        criterion = Restrictions.like(key, value, MatchMode.ANYWHERE).ignoreCase();
                    }
                    break;
                case "(I)":
                case "(L)":
                case "(d)":
                    criterion = parseNumber(key, value, prefix);
                    break;
                case "(D)":
                    criterion = parseDate(key, value);
                    break;
                case "(B)":
                    criterion = Restrictions.eq(key, Boolean.parseBoolean(value));
                    break;
                case "(in)":
                    criterion = Restrictions.in(key, parseList(value));
                    break;
                case "(notIn)":
                    criterion = Restrictions.not(Restrictions.in(key, parseList(value)));
                    break;
                default:
                    criterion = Restrictions.eq(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return criterion;
    }

    public static void main(String[] args) {
        System.out.println(Restrictions.not(Restrictions.in("id", new Integer[]{0})));
        //not id in (0)
    }

    private static Criterion parseNumber(String key, String valueStr, String type) {
        String operator = "";
        Object value = null;
        Criterion criterion = null;

        System.out.println("parseNumber:: valueStr = " + valueStr);
        if (valueStr.trim().startsWith("[")) {
            operator = valueStr.trim().substring(1, valueStr.indexOf("]"));
            valueStr = valueStr.trim().substring(valueStr.indexOf("]") + 1);
        }

        switch (type) {
            case "(I)":
                value = Integer.parseInt(valueStr);
                break;
            case "(L)":
                value = Long.parseLong(valueStr);
                break;
            case "(d)":
                value = Double.parseDouble(valueStr);
                break;
            default:
                value = valueStr;
        }
        switch (operator) {
            case "ne":
                criterion = Restrictions.ne(key, value);
                break;
            case "gt":
                criterion = Restrictions.gt(key, value);
                break;
            case "lt":
                criterion = Restrictions.lt(key, value);
                break;
            case "ge":
                criterion = Restrictions.ge(key, value);
                break;
            case "le":
                criterion = Restrictions.le(key, value);
                break;
            case "eq":
            default:
                criterion = Restrictions.eq(key, value);
                break;

        }

        if (criterion == null) {
            System.out.println("criterion is NULL");
        }

        return criterion;
    }

    private static Criterion parseDate(String key, String value) {
        Criterion criterion = null;
        if (value.contains(",")) {
            System.out.println("value = " + value);
            String[] dates = value.split(",");

            System.out.println("date1 = " + dates[0]);
            System.out.println("date2 = " + dates[1]);
            Criterion startDateCriterion = null, endDateCriterion = null;
            if (hasValue(dates[0])) {
                startDateCriterion = Restrictions.ge(key, new Date(dates[0]));
            }

            if (hasValue(dates[1])) {
                Date endDate = new Date(dates[1]);
                endDate.setHours(23);
                endDate.setMinutes(59);
                endDate.setSeconds(59);
                endDateCriterion = Restrictions.le(key, endDate);
            }

            if (startDateCriterion != null && endDateCriterion != null) {
                criterion = Restrictions.and(startDateCriterion, endDateCriterion);
            } else {
                criterion = startDateCriterion == null ? endDateCriterion : startDateCriterion;
            }

        } else {
            criterion = Restrictions.eq(key, new Date(value));
        }
        return criterion;
    }

    private static boolean hasValue(String str) {
        return str != null && !str.isEmpty() && !str.equalsIgnoreCase("null");
    }

    public static Hash parseRequestMap(Hash request) throws ParseException {

        List<String> names = new ArrayList(request.keySet());

        for (String name : names) {
            String value = request.getString(name);
            parse(name, value, request);
        }

        return request;
    }

    private static <T extends Map> void parse(String key, String value, T request) {
        try {
            if (value.length() >= 3) {
                String prefix = value.substring(0, 3);
                value = value.substring(3);

                if (value.isEmpty() || value.equalsIgnoreCase("null")) {
                    request.remove(key);
                    return;
                }

                switch (prefix) {
                    case "(I)":
                        request.put(key, Integer.parseInt(value));
                        break;
                    case "(L)":
                        request.put(key, Long.parseLong(value));
                        break;
                    case "(D)":
                        request.put(key, new Date(value));
                        break;
                    case "(d)":
                        request.put(key, Double.parseDouble(value));
                        break;
                    case "(B)":
                        request.put(key, Boolean.parseBoolean(value));
                        break;
                    case "(C)":
                        if (value != null && !value.isEmpty()) {
                            request.put(key, value.charAt(0));
                        }
                        break;
                    default:
                        request.put(key, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.put(key, value);
        }
    }

    public static Integer[] parseList(String value) {
        String[] parts = value.split(",");
        Integer[] list = new Integer[parts.length];

        for (int i = 0; i < parts.length; i++) {
            list[i] = Integer.parseInt(parts[i]);
        }
        return list;
    }

    public static String getMaskedNumber(String cardNumber) {
        String maskedNumber = "";
        if (cardNumber != null && cardNumber.length() >= 4) {
            maskedNumber += cardNumber.substring(0, 4);

            if (cardNumber.length() >= 8) {
                maskedNumber += "********";
                maskedNumber += cardNumber.substring(cardNumber.length() - 4);
            }
        }
        return maskedNumber;
    }

    public static boolean equalAmounts(Double a, Double b) {
        return (a != null) && (b != null) && (Math.abs(a - b) < 0.01);
    }
}
