package main.util.enums;

public enum LanguageEnumUtil {
    DE("de");
    private String description;
    LanguageEnumUtil(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }
}
