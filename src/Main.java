package ru.practicum.dinner;
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
        if (dinnerConstructor.nameOfDishArray.contains(dishName)) {
            System.out.println("это блюдо уже есть в списке");
        } else {
            dinnerConstructor.saveNameMenu(dishType, dishName);
        }



    }

    private static void generateDishCombo() {

        if (!dinnerConstructor.dinnerMenuMap.isEmpty()) {
            System.out.println("Начинаем конструировать обед...");
            System.out.println("Введите количество наборов, которые нужно сгенерировать: 1,2,3,4,5");
            int numberOfCombos = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). " +
                    "Для завершения ввода введите пустую строку");
            System.out.println("В меню добавленны: " + dinnerConstructor.keyMenuArray);
            String nextItem = scanner.nextLine();

            if (dinnerConstructor.dinnerMenuMap.containsKey(nextItem)) {
                while (!nextItem.isEmpty()) {
                    if (dinnerConstructor.keyMenuArray.contains(nextItem)) {
                        System.out.println("Этот тип блюда уже добавлен в обед");
                        break;

                    } else {
                        dinnerConstructor.keyMenuArray.add(nextItem);
                        nextItem = scanner.nextLine();

                    }
                }
                        dinnerConstructor.mixComboMenu(numberOfCombos);

            } else {
                System.out.println("Такого типа блюд нет");
            }


        } else {
            System.out.println("Сначала добавьте блюдо ");
        }

    }
}