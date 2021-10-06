package model;

import java.util.List;

public class CountryAndLanguage {
    private String country;
    private List<String> languages;

    public CountryAndLanguage(){

    }
    public CountryAndLanguage(String country, List<String> languages){
        this.country=country;
        this.languages=languages;
    }
    public  String getCountry(){
        return country;
    }
    public  void setCountry(String country){
        this.country=country;
    }
    public  List<String> getLanguages(){
        return languages;
    }
    public void setLanguages(List<String> languages){
        this.languages=languages;
    }

    public Long getSizeLanguage(){
        return languages.stream().count();
    }
}
