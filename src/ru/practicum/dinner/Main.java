package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    static HashMap<String, ArrayList<String>> dishList = new HashMap<>();

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
//        System.out.println("Введите тип блюда:");
//        String dishType = scanner.nextLine();
//        System.out.println("Введите название блюда:");
//        String dishName = scanner.nextLine();
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

//        if (dishList.containsKey(dishType)) {
//            dishList.get(dishType).add(dishName);
//        } else {
//            ArrayList<String> newTypeList = new ArrayList<>();
//            newTypeList.add(dishName);
//            dishList.put(dishType, newTypeList);
//        }

        for (String string : dishList.keySet()) {
            System.out.println("Теперь в типах: " + string + " следующие блюда: " + dishList.get(string));
        }
    }

    private static void generateDishCombo() {

        ArrayList<String> dishTypeCombo = new ArrayList<>();

        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        while (true) {
            String nextItem = scanner.nextLine();
            //реализация ввода типов блюд
            if (!nextItem.isEmpty()) {
                if (dc.checkType(dishList, nextItem)) {
                    dishTypeCombo.add(nextItem);
                } else {
                    System.out.println("Такого типа блюд нет. Выберите другой");
                }
            } else {
                dc.dishGenerator(dishList, dishTypeCombo, numberOfCombos);
                break;
            }

        }

        // сгенерируйте комбинации блюд и выведите на экран
    }
}
