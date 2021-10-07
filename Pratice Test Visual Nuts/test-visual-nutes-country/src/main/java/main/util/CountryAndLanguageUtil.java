package main.util;

import main.model.CountryAndLanguage;

import java.util.List;
import java.util.Map;

public interface CountryAndLanguageUtil {
    List<CountryAndLanguage> convertJsonToObject(String json);
    Integer numberOfcountriesInTheWord(List<CountryAndLanguage> list);
    Map<String, Long> countsAllOficialLanguagesSpokenInCountries(List<CountryAndLanguage> list);
    CountryAndLanguage findCountryWithHighestNumberLanguages(List<CountryAndLanguage> list);
    Map<String, Long> findMostCommonOfficialLanguagesWhereLanguage(List<CountryAndLanguage> list,String language);
    Integer numberOfOfficialLanguages(List<CountryAndLanguage> list);
    String findMoustCommonLanguage(List<CountryAndLanguage> list);
    List<CountryAndLanguage> getCountryAndLanguageList();
}
