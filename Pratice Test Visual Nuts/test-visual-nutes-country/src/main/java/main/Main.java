package main;

import main.util.QuestionUtil;
import main.util.QuestionUtilImpl;



public class Main {
    public static void main(String[] args) {
        QuestionUtil util = new QuestionUtilImpl();
        util.getQuestions().forEach(runnable -> runnable.run());
    }
}
