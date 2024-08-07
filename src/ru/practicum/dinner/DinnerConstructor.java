package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    Random random = new Random();
    static HashMap<String, ArrayList<String>> dishList = new HashMap<>(); // Объявление Хэштаблицы с типами блюд и списками блюд
    ArrayList<String> dishTypeCombo = new ArrayList<>(); // объявление списка выбранных для комбо типов блюд

    void addDish(String dishType, String dishName) { // метод, добавляющий типы блюд и блюда в список
        if (dishList.containsKey(dishType)) { // если тип уже есть в списке
            dishList.get(dishType).add(dishName);
        } else { // если нет
            addNewDishTypeAndDish(dishType, dishName);
        }
    }

    Boolean checkType(HashMap<String, ArrayList<String>> dishList, String dishType) { // проврка на наличие типа в списке
        return dishList.containsKey(dishType);
    }

    void dishGenerator(int numberOfCombos) { // создание и печать комбо
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> comboMenu = new ArrayList<>();

            for (String s : dishTypeCombo) {
                comboMenu.add(dishRandomizer(dishList.get(s)));
            }
            System.out.println("Комбо " + (i + 1));
            System.out.println(comboMenu);
        }
        System.out.println(); // для отделения от следующей итерации
    }

    String dishRandomizer(ArrayList<String> dishArrayList) {
        return dishArrayList.get(random.nextInt(dishArrayList.size()));
    }

    void dishTypeChoice(String nextItem) { // добавление типа в список комбо
        if (checkType(dishList, nextItem)) {
            dishTypeCombo.add(nextItem);
        } else {
            System.out.println("Такого типа блюд нет. Выберите другой");
        }
    }

    void addNewDishTypeAndDish(String dishType, String dishName) { // добавление новых типов блюд и самих блюд
        ArrayList<String> newTypeList = new ArrayList<>();
        newTypeList.add(dishName);
        dishList.put(dishType, newTypeList);
    }
}
