package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> dishList = new HashMap<>();

    void addNewMeal(String dishType, String dishName) {

        if (dishList.containsKey(dishType)) {
            dishList.get(dishType).add(dishName);
        } else {
            ArrayList<String> newTypeList = new ArrayList<>();
            newTypeList.add(dishName);
            dishList.put(dishType, newTypeList);
        }

        for (String string : dishList.keySet()) {
            System.out.println("Теперь в типах: " + string + " следующие блюда: " + dishList.get(string));
        }
    }
}
