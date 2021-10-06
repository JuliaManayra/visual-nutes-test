import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import model.CountryAndLanguage;
import model.CountryAndLanguageList;
import util.CountryAndLanguageUtil;
import util.CountryAndLanguageUtilImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;


public class Main {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/json/contries.json"));
        CountryAndLanguageList countryAndLanguageList =objectMapper.readValue(jsonNode.toString(), new TypeReference<CountryAndLanguageList>(){});
        CountryAndLanguageUtil util = new CountryAndLanguageUtilImpl();

        System.out.println("\nreturns the number of countries in the world:");
        System.out.println("number of coutries: "+ util.numberOfcountriesInTheWord(Optional.ofNullable(countryAndLanguageList).map(CountryAndLanguageList::getList).orElse(new ArrayList<>()))+"\n");

        System.out.println("finds the country with the most official languages, where they officially speak German (de):");
        Map<String,Long> map= util.findMostCommonOfficialLanguagesWhereLanguage(Optional.ofNullable(countryAndLanguageList).map(CountryAndLanguageList::getList).orElse(new ArrayList<>()),"de");
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            System.out.println("Country: "+ entry.getKey() + " - Number of Languages: " + entry.getValue().toString()+"\n");
        }
        System.out.println("\n");

        System.out.println("that counts all the official languages spoken in the listed countries");
        System.out.println("number languages: "+ util.numberOfOfficialLanguages(Optional.ofNullable(countryAndLanguageList)
                .map(CountryAndLanguageList::getList).orElse(new ArrayList<>()))+"\n");
        System.out.println(" to find the country with the highest number of official languages" );
        CountryAndLanguage country = util.findCountryWithHighestNumberLanguages(Optional.ofNullable(countryAndLanguageList).map(CountryAndLanguageList::getList).orElse(new ArrayList<>()));
        System.out.println("country: "+ country.getCountry()+"\n");


        System.out.println(" - to find the most common official language(s), of all countries" );
        System.out.println("Language: "+ util.findMoustCommonLanguage(Optional.ofNullable(countryAndLanguageList).map(CountryAndLanguageList::getList).orElse(new ArrayList<>()))+"\n");

    }
}
