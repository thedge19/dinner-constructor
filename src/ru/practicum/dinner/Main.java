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
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

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

    private static void generateDishCombo() {

        ArrayList<String> dishTypeCombo = new ArrayList<>();

        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            if (dc.checkType(dishList, nextItem)) {
                dishTypeCombo.add(nextItem);
            } else {
                System.out.println("Такого типа блюд в меню нет");
            }
        }

        System.out.println(dishTypeCombo);

        // сгенерируйте комбинации блюд и выведите на экран
    }
}
