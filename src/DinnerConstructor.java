package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinnerMenuMap = new HashMap<>();
    Random random = new Random();
    ArrayList<String> keyMenuArray = new ArrayList<>();
    ArrayList<String> nameOfDishArray = new ArrayList<>();


    DinnerConstructor() {
        dinnerMenuMap = new HashMap<>();
    }

    HashMap saveNameMenu(String typeOfDish, String nameOfDish) {
        if (dinnerMenuMap.containsKey(typeOfDish)) {
            nameOfDishArray = dinnerMenuMap.get(typeOfDish);
            nameOfDishArray.add(nameOfDish);
        } else {
            nameOfDishArray = new ArrayList<>();
            nameOfDishArray.add(nameOfDish);
            dinnerMenuMap.put(typeOfDish, nameOfDishArray);
        }
        return dinnerMenuMap;

    }


    void mixComboMenu(Integer numberOfCombos) {

        for (int j = 0; j < numberOfCombos; j++) {
            System.out.println("Комбо меню " + (j + 1));

            for (int i = 0; i < keyMenuArray.size(); i++) {
                ArrayList<String> src = dinnerMenuMap.get(keyMenuArray.get(i));
                int xRandom = random.nextInt(src.size());
                System.out.println("На " + (i + 1) + ". " + src.get(xRandom));
            }
        }
    }
    void testmethod() {

        ArrayList<String> firstdinner = new ArrayList<>();
        ArrayList<String> seconddinner = new ArrayList<>();
        ArrayList<String> thirddinner = new ArrayList<>();

        firstdinner.add("Сок");
        firstdinner.add("Кола");
        firstdinner.add("Лимонад");

        seconddinner.add("Гречка");
        seconddinner.add("Пюре");
        seconddinner.add("Макароны");

        thirddinner.add("Котлета");
        thirddinner.add("Поджарка");
        thirddinner.add("Стейк");

        dinnerMenuMap.put("напиток", firstdinner);
        dinnerMenuMap.put("гарнир", seconddinner);
        dinnerMenuMap.put("мясо", thirddinner);
        System.out.println(dinnerMenuMap);

    }
}




























