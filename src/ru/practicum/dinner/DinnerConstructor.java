package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    Random random = new Random();
    static HashMap<String, ArrayList<String>> dishList = new HashMap<>();
    ArrayList<String> dishTypeCombo = new ArrayList<>();

    void addDish() {
        ArrayList<String> newTypeList1 = new ArrayList<>();
        newTypeList1.add("Щи");
        newTypeList1.add("Борщ");
        newTypeList1.add("Уха");
        dishList.put("Суп", newTypeList1);

        ArrayList<String> newTypeList2 = new ArrayList<>();
        newTypeList2.add("Отбивная");
        newTypeList2.add("Азу");
        newTypeList2.add("Стейк");
        dishList.put("Мясо", newTypeList2);

        ArrayList<String> newTypeList3 = new ArrayList<>();
        newTypeList3.add("Рис");
        newTypeList3.add("Булгур");
        newTypeList3.add("Гречка");
        dishList.put("Гарнир", newTypeList3);

        ArrayList<String> newTypeList4 = new ArrayList<>();
        newTypeList4.add("Квас");
        newTypeList4.add("Морс");
        newTypeList4.add("Кола");
        dishList.put("Напиток", newTypeList4);

        ArrayList<String> newTypeList5 = new ArrayList<>();
        newTypeList5.add("Оливье");
        newTypeList5.add("Витаминный");
        newTypeList5.add("Винегрет");
        dishList.put("Салат", newTypeList5);

        for (String string : dishList.keySet()) {
            System.out.println("Теперь в типах: " + string + " следующие блюда: " + dishList.get(string));
        }
    }

    Boolean checkType(HashMap<String, ArrayList<String>> dishList, String dishType) {
        return dishList.containsKey(dishType);
    }

    void dishGenerator(int numberOfCombos) {
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> comboMenu = new ArrayList<>();

            for (String s : dishTypeCombo) {
                comboMenu.add(dishRandomizer(dishList.get(s)));
            }
            System.out.println("Комбо " + (i + 1));
            System.out.println(comboMenu);
        }
    }

    String dishRandomizer(ArrayList<String> dishArrayList) {
        return dishArrayList.get(random.nextInt(dishArrayList.size()));
    }

    void dishTypeChoice(String nextItem) {
        if (checkType(dishList, nextItem)) {
            dishTypeCombo.add(nextItem);
        } else {
            System.out.println("Такого типа блюд нет. Выберите другой");
        }
    }
}
