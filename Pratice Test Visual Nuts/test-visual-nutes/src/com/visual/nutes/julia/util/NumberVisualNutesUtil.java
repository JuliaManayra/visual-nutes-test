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

    public void teste(String json) {
        String countryPattern = "[\\\"]*[a-z]*[\\\"]:[\\\"]*[a-zA-Z]*[\\\"]";
        String countryAndLanguagePattern = "[\\[\\\"][a-zA-Z,\\\"]*[\\\"\\]]";
        String nameAndValue = "\\\"[A-Za-z]*\\\":( |)[\\[\\\",a-zA-Z\\]]*";
        String patternAtc = "\\\"[A-Za-z]*\\\":[\\[\\\",a-zA-Z\\]]*";
        System.out.println(json);

        Pattern pattern = Pattern.compile(countryPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(json);
        while (matcher.find()) {
            System.out.println("Match found: " + matcher.group());
        }

        System.out.println("\n\n\n versao 2");
        Pattern pattern2 = Pattern.compile(countryAndLanguagePattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(json);
        while (matcher2.find()) {
            System.out.println("Match found 2 :" + matcher2.group());
        }

        String teste= "\"languages\": [\"nl\",\"fy\"]";
        System.out.println("\n\n\n versao 3");
        Pattern pattern3 = Pattern.compile(patternAtc, Pattern.CASE_INSENSITIVE);
        Matcher matcher3 = pattern3.matcher(teste);
        while (matcher3.find()) {
            System.out.println("Match found  3 :" + matcher3.group());
        }


        System.out.println("\n\n\n versao 4");
        Pattern pattern4 = Pattern.compile(nameAndValue, Pattern.CASE_INSENSITIVE);
        Matcher matcher4 = pattern4.matcher(json);
        while (matcher4.find()) {
            System.out.println("Match found  4 :" + matcher4.group());
        }

    }
}