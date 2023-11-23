package HW_3;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class task3 {
    //    Напишите функцию analyzeNumbers, которая принимает на вход целочисленный список arr и:
//    Сортирует его по возрастанию и выводит на экран
//    Находит минимальное значение в списке и выводит на экран - Minimum is {число}
//    Находит максимальное значение в списке и выводит на экран - Maximum is {число}
//    Находит среднее арифметическое значений списка и выводит на экран - Average is =  {число}
//    Напишите свой код в методе analyzeNumbers класса Answer.
//    Метод analyzeNumbers принимает на вход один параметр: Integer[] arr - список целых чисел
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        task3 ans = new task3();
        ans.analyzeNumbers(arr);
    }

    static void analyzeNumbers(Integer[] arr) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));

        // Сортируем по возрастанию
        Collections.sort(list);
        System.out.println(list);

        // Находим минимальное значение
        int min = list.get(0);
        System.out.println("Minimum is " + min);

        // Находим максимальное значение
        int max = list.get(list.size() - 1);
        System.out.println("Maximum is " + max);

        // Находим среднее арифметическое
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        int average = sum / list.size();
        System.out.println("Average is = " + average);
    }
}

