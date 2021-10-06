package com.visual.nutes.julia.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberVisualNutesUtil {


    private String getValueDivisibleByNumber(Integer number, Integer value, String text) {
        if (value >= number) {
            if ((value % number) == 0) {
                return text;
            }
            return getValueDivisibleByNumber(number, value % number, text);
        }
        return "";
    }

    public String getValueDivisibleByTwoNumber(Integer value,
                                               Integer numberA, Integer numberB, String strValueA, String strValueB) {
        String str = getValueDivisibleByNumber(numberA, value, strValueA) + " "
                + getValueDivisibleByNumber(numberB, value, strValueB);
        if (!str.trim().isEmpty()) {
            return str.trim();
        }
        return Integer.toString(value);
    }
}
