package HW_3;

import java.util.Arrays;
import java.util.ArrayList;

public class task2 {
    //    Напишите функцию removeEvenNumbers, которая принимала бы произвольный список целых чисел,
//    удаляла бы из него четные числа и выводила список без четных чисел.
//    Напишите свой код в методе removeEvenNumbers класса Answer.
//    Метод removeEvenNumbers принимает на вход один параметр: Integer[] arr - список целых чисел
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//            arr = new Integer[]{2, 4, 6, 8}; выведет пустой список

        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        task2 ans = new task2();
        ans.removeEvenNumbers(arr);
    }
    public static void removeEvenNumbers(Integer[] arr) {
        // Преобразуем массив в список для удобства удаления элементов
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));

        // Используем стрим для фильтрации четных чисел
        list.removeIf(num -> num % 2 == 0);

        // Преобразуем список обратно в массив
        Integer[] result = list.toArray(new Integer[0]);

        // Выводим результат
        System.out.println(Arrays.toString(result));
    }
}



