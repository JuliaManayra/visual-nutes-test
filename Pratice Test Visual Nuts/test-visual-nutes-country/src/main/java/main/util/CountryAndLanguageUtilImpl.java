package main.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import main.model.CountryAndLanguage;
import main.model.CountryAndLanguageList;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class CountryAndLanguageUtilImpl implements CountryAndLanguageUtil{
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");

    public List<CountryAndLanguage> getCountryAndLanguageList(){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/json/contries.json"));
            return convertJsonToObject(jsonNode.toString());
        }catch (IOException e){
            LOGGER.info("ERRO " + e);
        }
        return new ArrayList<>();
    }

    public List<CountryAndLanguage> convertJsonToObject(String json){
        Gson gson = new Gson();
        CountryAndLanguageList list = gson.fromJson(json, CountryAndLanguageList.class);
        return Optional.ofNullable(list).map(CountryAndLanguageList::getList).orElse(new ArrayList<>());
    }

    public Integer numberOfcountriesInTheWord(List<CountryAndLanguage> list){
        return (int) list.stream().distinct().count();
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
        return (int) list
                .stream()
                .map(CountryAndLanguage::getLanguages)
                .flatMap(List::stream)
                .distinct().count();
    }

    @Override
    public String findMoustCommonLanguage(List<CountryAndLanguage> list){
        List<String> languages = list
                .stream()
                .map(CountryAndLanguage::getLanguages)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return  languages.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting())).entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey).orElse("");

    }

}
