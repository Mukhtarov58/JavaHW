package HW_6;

import java.util.*;

//    Задание: Реализуйте структуру телефонной книги с помощью HashMap. Программа также должна учитывать,
//    что в во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать,
//    как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();
        addContact(phoneBook, "Иванов", "123456789");
        addContact(phoneBook, "Петров", "987654321");
        addContact(phoneBook, "Сидоров", "111222333");
        addContact(phoneBook, "Иванов", "+555666777");
        addContact(phoneBook, "Иванов", "123454321");
        addContact(phoneBook, "Сидоров", "000111222");
        printSortedContacts(phoneBook);
    }

    /**
     * Метод для добавления контакта в телефонную книгу
     *
     * @param phoneBook
     * @param name
     * @param phoneNumber
     */
    private static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        // Если имя уже есть в книге, добавляем телефон к существующему списку
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNumber);
        } else {
            // Иначе создаем новую запись в книге
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    /**
     * Метод для вывода телефонной книги
     *
     * @param phoneBook
     */
    private static void printSortedContacts(HashMap<String, List<String>> phoneBook) {
        phoneBook.entrySet().stream()
                //Сортируем выводимый список по убыванию числа телефонов.
                .sorted(Comparator.<Map.Entry<String, List<String>>>comparingInt(entry -> entry.getValue().size()).reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}

