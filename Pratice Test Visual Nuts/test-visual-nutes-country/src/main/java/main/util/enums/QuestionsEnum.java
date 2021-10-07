package main.util.enums;

public enum QuestionsEnum {

    ONE("1- Returns the number of countries in the world:"),
    TWO("2 - Finds the country with the most official languages, where they officially speak German (de):"),
    THREE("3- That counts all the official languages spoken in the listed countries:"),
    FOUR("4- to find the country with the highest number of official languages:"),
    FIVE("5 - to find the most common official language(s), of all countries:");
    private String description;

    QuestionsEnum(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }
}
