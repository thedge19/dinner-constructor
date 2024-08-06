package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    Random random = new Random();


    Boolean checkType(HashMap<String, ArrayList<String>> dishList, String dishType) {
        return dishList.containsKey(dishType);
    }

    void dishGenerator(HashMap<String, ArrayList<String>> dishList, ArrayList<String> dishTypeCombo, int numberOfCombos) {
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбо №" + (i + 1) + ": " + dishTypeCombo.get(i)); // заведомо неправильно
        }
    }
}
