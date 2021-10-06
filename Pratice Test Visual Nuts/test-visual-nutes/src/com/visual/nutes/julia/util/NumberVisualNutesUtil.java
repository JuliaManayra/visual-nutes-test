package com.visual.nutes.julia.util;


import com.visual.nutes.julia.util.enums.VisualNutesEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NumberVisualNutesUtil {


    private String getValueDivisibleByNumber(Integer number, Integer value, String text) {
        if (isValueDivisibleByNumber(number, value)) {
            return text;
        }
        return "";
    }

    private boolean isValueDivisibleByNumber(Integer number, Integer value) {
        return Math.floorMod(value, number) == 0;
    }

    public String getValueDivisibleByTwoNumber(Integer value,
                                               Integer numberA, Integer numberB, String strValueA, String strValueB) {
        String str = getNumberOrTextByRuleNumbersDivisiblesByAOrB(value, numberA, numberB, strValueA, strValueB);
        if (!str.isEmpty()) {
            return str;
        }
        return Integer.toString(value);
    }

    private String getNumberOrTextByRuleNumbersDivisiblesByAOrB(Integer value, Integer numberA, Integer numberB, String strValueA, String strValueB) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( getValueDivisibleByNumber(numberA, value, strValueA));
        stringBuilder.append(" ");
        stringBuilder.append( getValueDivisibleByNumber(numberB, value, strValueB));
        return stringBuilder.toString().trim();
    }

    public List<String> getListNumberReplaceToVisualNutesDivisibleByTwoNumberOrIndividualNumber(Integer size, Integer numberA, Integer numberB){
        List<String>  list= new ArrayList<>();
        Integer numA = getValidNumberOrElse(numberA,3);
        Integer numB = getValidNumberOrElse(numberB,5);
        for(var i = 1; i<= getValidNumberOrElse(size,100) ; i++){
            list.add(getValueDivisibleByTwoNumber(i,numA,numB, VisualNutesEnum.VISUAL.getDescription(), VisualNutesEnum.NUTES.getDescription()));
        }
        return list;
    }

    private Integer getValidNumberOrElse(Integer number, Integer orElse){
        return Optional.ofNullable(number).orElse(orElse);
    }
}
