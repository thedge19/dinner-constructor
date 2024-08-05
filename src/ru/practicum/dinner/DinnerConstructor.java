package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {

    Boolean checkType(HashMap<String, ArrayList<String>> dishList, String dishType) {
        return dishList.containsKey(dishType);
    }
}
