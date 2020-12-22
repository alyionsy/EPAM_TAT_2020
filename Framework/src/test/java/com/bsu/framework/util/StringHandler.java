package com.bsu.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringHandler {
    public static Date stringToDateConverter(String date) {
        try {
            return new SimpleDateFormat("[yyyy-MM-dd]").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int stringToIntConverter(String number) {
        return Integer.parseInt(number.substring("Sales:".length()).replace(",", ""));
    }
}
