package HW_4;

import java.util.LinkedList;

//Пусть дан LinkedList с несколькими элементами.
// Напишите класс LLTasks с методом revert, который принимал бы на вход LinkedList и возвращает “перевернутый” список.
public class task1 {
    public static void main(String[] args) {
        LinkedList<Object> ll = new LinkedList<>();

        if (args.length == 0 || args.length != 4) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            ll.add(1);
            ll.add("One");
            ll.add(2);
            ll.add("Two");
        } else {
            ll.add(Integer.parseInt(args[0]));
            ll.add(args[1]);
            ll.add(Integer.parseInt(args[2]));
            ll.add(args[3]);
        }

        LLTasks answer = new LLTasks();
        System.out.println(ll);
        LinkedList<Object> reversedList = answer.revert(ll);
        System.out.println(reversedList);
    }

    static class LLTasks {
        public LinkedList<Object> revert(LinkedList<Object> ll) {
            LinkedList<Object> reversedList = new LinkedList<>();

            // Идем по исходному списку с конца и добавляем элементы в новый список
            for (int i = ll.size() - 1; i >= 0; i--) {
                reversedList.add(ll.get(i));
            }

            return reversedList;
        }
    }
}

