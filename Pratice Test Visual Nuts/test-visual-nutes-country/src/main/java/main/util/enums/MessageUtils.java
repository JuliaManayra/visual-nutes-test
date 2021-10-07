package main.util.enums;

public enum MessageUtils {

    LANGUAGE("Language : "),
    COUNTRY("Country : "),
    NUMBER_LANGUAGE("Number of Language : "),
    NUMBER_COUNTRY("Number of Country :");
    private String description;

    MessageUtils(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }
}
