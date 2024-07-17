package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static DinnerConstructor dinnerConstructor;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        dinnerConstructor = new DinnerConstructor();


        dc = new DinnerConstructor();

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
        System.out.println(" ");
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
        System.out.print("Ваш выбор: ");
    }

    private static void addNewDish() {


        System.out.println("Введите тип блюда: (например: напиток, гарнир, мясо)");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        boolean select = true;
        for (ArrayList<String> src : dinnerConstructor.dinnerMenuMap.values()) {
            if (src.contains(dishName)) {
                select = false;
            }
        }
        if (!select) {
            System.out.println("это блюдо уже есть в списке");
        } else {
            dinnerConstructor.saveNameMenu(dishType, dishName);
        }
    }

    private static void generateDishCombo() {

        if (!dinnerConstructor.dinnerMenuMap.isEmpty()) {
            ArrayList<String> keyMenuArray = new ArrayList<>();
            System.out.println("Начинаем конструировать обед...");
            System.out.println("Введите количество наборов, которые нужно сгенерировать: 1,2,3,4,5");
            int numberOfCombos = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). " +
                    "Для завершения ввода введите пустую строку");

            String nextItem = scanner.nextLine();

            if (dinnerConstructor.dinnerMenuMap.containsKey(nextItem)) {
                while (!nextItem.isEmpty()) {
                    keyMenuArray.add(nextItem);
                    nextItem = scanner.nextLine();
                }
                dinnerConstructor.mixComboMenu(numberOfCombos, keyMenuArray);


            } else {
                System.out.println("Такого блюда нет или еще не добавленно ");
            }
        }
    }
}
