package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinnerMenuMap;
    Random random = new Random();


    DinnerConstructor() {
        dinnerMenuMap = new HashMap<>();
    }

    void saveNameMenu(String typeOfDish, String nameOfDish) {
        dinnerMenuMap.computeIfAbsent(typeOfDish, k -> new ArrayList<>()).add(nameOfDish);
    }


    void mixComboMenu(Integer numberOfCombos, ArrayList<String> keyMenuArray) {

        for (int j = 0; j < numberOfCombos; j++) {
            System.out.println("Комбо меню " + (j + 1));

            for (int i = 0; i < keyMenuArray.size(); i++) {
                ArrayList<String> src = dinnerMenuMap.get(keyMenuArray.get(i));
                int xRandom = random.nextInt(src.size());
                System.out.println("На " + (i + 1) + ". " + src.get(xRandom));
            }
        }
    }
}