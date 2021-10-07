package main.model;

import java.util.List;

public class CountryAndLanguageList {
    private List<CountryAndLanguage> list;
    public void setList(List<CountryAndLanguage> list){
        this.list=list;
    }

    public List<CountryAndLanguage> getList(){
      return list;
    }
}
