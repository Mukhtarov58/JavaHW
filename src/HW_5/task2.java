package HW_5;

import java.util.HashMap;

public class task2 {
    //    Вы работаете с приложением для учета имен пользователей. Ваша задача - разработать программу,
//    которая принимает на вход пять имен пользователей (или использует имена по умолчанию,
//    если аргументы не предоставлены) и подсчитывает, сколько раз каждое имя встречается.
//    Программа должна использовать HashMap для хранения имен и их количества вхождений.
//    По завершении, программа выводит результат в виде пар "имя - количество".
    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        String name4;
        String name5;
        String name6;

        if (args.length == 0) {
            name1 = "Elena";
            name2 = "Elena";
            name3 = "Elena";
            name4 = "Elena";
            name5 = "Ivan";
            name6 = "Tigran";
        } else {
            name1 = args[0];
            name2 = args[1];
            name3 = args[2];
            name4 = args[3];
            name5 = args[4];
            name6 = args[5];
        }
        NamesCounter namesCounter = new NamesCounter();

        namesCounter.addName(name1);
        namesCounter.addName(name2);
        namesCounter.addName(name3);
        namesCounter.addName(name4);
        namesCounter.addName(name5);
        namesCounter.addName(name6);
        namesCounter.showNamesOccurrences();
    }
}
class NamesCounter {
    private HashMap<String, Integer> names = new HashMap<>();

    // Метод для добавления имени в HashMap
    public void addName(String name) {
        // Проверяем, существует ли имя в HashMap
        if (names.containsKey(name)) {
            // Если имя уже есть, увеличиваем количество вхождений на 1
            int count = names.get(name);
            names.put(name, count + 1);
        } else {
            // Если имя новое, добавляем его с начальным количеством 1
            names.put(name, 1);
        }
    }

    // Метод для вывода содержимого HashMap
    public void showNamesOccurrences() {
        System.out.println(names);
    }
}

