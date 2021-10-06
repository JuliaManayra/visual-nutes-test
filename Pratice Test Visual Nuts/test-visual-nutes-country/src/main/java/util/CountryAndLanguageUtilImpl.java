package util;

import com.google.gson.Gson;
import model.CountryAndLanguage;
import model.CountryAndLanguageList;

import java.util.*;
import java.util.stream.Collectors;


public class CountryAndLanguageUtilImpl implements CountryAndLanguageUtil{

    public List<CountryAndLanguage> convertJsonToObject(String json){
        Gson gson = new Gson();
        CountryAndLanguageList list = gson.fromJson(json, CountryAndLanguageList.class);
        return list.getList();
    }

    public Integer numberOfcountriesInTheWord(List<CountryAndLanguage> list){
        return list.stream().distinct()
                .collect(Collectors.toList()).size();
    }

    public Map<String, Long>countsAllOficialLanguagesSpokenInCountries(List<CountryAndLanguage> list){
        return list.stream()
                .collect(
                        Collectors.toMap(
                                CountryAndLanguage::getCountry,
                                 CountryAndLanguage::getSizeLanguage
                        )
                );
    }


    public CountryAndLanguage findCountryWithHighestNumberLanguages(List<CountryAndLanguage> list){
        return list
                .stream()
                .max(Comparator.comparing(CountryAndLanguage::getSizeLanguage))
                .orElseThrow(NoSuchElementException::new);
    }


    private List<CountryAndLanguage> findContryLanguagesWhereLanguage(List<CountryAndLanguage> list, String language){
        return list
                .stream()
                .filter(c-> c.getLanguages().contains(language))
                .collect(Collectors.toList());
    }

    public Map<String, Long> findMostCommonOfficialLanguagesWhereLanguage(List<CountryAndLanguage> list, String language){


       List<CountryAndLanguage> coutries = findContryLanguagesWhereLanguage(list,language);

        return countsAllOficialLanguagesSpokenInCountries(coutries);
    }

    @Override
    public Integer numberOfOfficialLanguages(List<CountryAndLanguage> list) {


        List<String> languages = list
                .stream()
                .map(CountryAndLanguage::getLanguages)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        return languages.size();
    }

    @Override
    public String findMoustCommonLanguage(List<CountryAndLanguage> list){
        List<String> languages = list
                .stream()
                .map(CountryAndLanguage::getLanguages)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return  languages.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting())).entrySet()
                        .stream()
                        .max(Comparator.comparing(Map.Entry::getKey))
                        .get()
                        .getKey();
    }

}
