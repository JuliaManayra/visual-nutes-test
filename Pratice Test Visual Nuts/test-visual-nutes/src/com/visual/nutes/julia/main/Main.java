package com.visual.nutes.julia.main;
import com.visual.nutes.julia.util.NumberVisualNutesUtil;

public class Main {

    public static void main(String[] args) {
        NumberVisualNutesUtil nutesUtil = new NumberVisualNutesUtil();
        for(int i=1;i<=100;i++){
            System.out.println(" "+nutesUtil.getValueDivisibleByTwoNumber(i,3,5,"Visual","Nutes"));
        }
    }
}
