package main.util;

import main.model.CountryAndLanguage;
import main.util.enums.LanguageEnumUtil;
import main.util.enums.MessageUtils;
import main.util.enums.QuestionsEnum;

import java.util.*;
import java.util.stream.Collectors;

public class QuestionUtilImpl implements QuestionUtil{
    private CountryAndLanguageUtil util;
    private List<CountryAndLanguage> countryAndLanguageList;
    public QuestionUtilImpl(){
        this.util = new CountryAndLanguageUtilImpl();
        this.countryAndLanguageList = this.util.getCountryAndLanguageList();
    }

    public void questionFive() {
        print(QuestionsEnum.FIVE.getDescription());
        print(MessageUtils.LANGUAGE.getDescription()+ util.findMoustCommonLanguage(countryAndLanguageList)+"\n");
    }

    public void questionFour() {
        print(QuestionsEnum.FOUR.getDescription());
        CountryAndLanguage country = util.findCountryWithHighestNumberLanguages(countryAndLanguageList);
        print(MessageUtils.COUNTRY.getDescription() + Optional.ofNullable(country).map(CountryAndLanguage::getCountry).orElse("")+"\n");
    }

    public void questionThree() {
        print(QuestionsEnum.THREE.getDescription());
        print(MessageUtils.NUMBER_LANGUAGE.getDescription()+ util.numberOfOfficialLanguages(countryAndLanguageList)+"\n");
    }

    public void questionTwo() {
        print(QuestionsEnum.TWO.getDescription());
        Map<String,Long> map= Optional.ofNullable(util.findMostCommonOfficialLanguagesWhereLanguage(countryAndLanguageList, LanguageEnumUtil.DE.getDescription())).orElse(new HashMap<>());
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            print(MessageUtils.COUNTRY.getDescription()+ entry.getKey() + " - "+MessageUtils.NUMBER_LANGUAGE.getDescription()+entry.getValue().toString());
        }
        print("\n");
    }

    public void questionOne() {
        print(QuestionsEnum.ONE.getDescription());
        print(MessageUtils.NUMBER_COUNTRY.getDescription()+ util.numberOfcountriesInTheWord(countryAndLanguageList)+"\n");
    }

    private void print(String s) {
        System.out.println(s);
    }

    public List<Runnable> getQuestions(){
        List<Runnable> list = new ArrayList<>();
        list.add(this::questionOne);
        list.add(this::questionTwo);
        list.add(this::questionThree);
        list.add(this::questionFour);
        list.add(this::questionFive);
        return list;
    }
}
