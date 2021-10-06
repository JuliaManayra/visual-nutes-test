package com.visual.nutes.julia.util.enums;

public enum VisualNutesEnum {
    VISUAL("Visual"),
    NUTES("Nutes");

    private String description;

    VisualNutesEnum(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }

}
