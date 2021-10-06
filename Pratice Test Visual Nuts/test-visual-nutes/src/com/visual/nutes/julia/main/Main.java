package com.visual.nutes.julia.main;
import com.visual.nutes.julia.util.NumberVisualNutesUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var nutesUtil = new NumberVisualNutesUtil();
        List<String> list = nutesUtil.getListNumberReplaceToVisualNutesDivisibleByTwoNumberOrIndividualNumber(100,3,5);
        list.stream().forEach(System.out::println);
    }
}
