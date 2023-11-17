package HW_1;

public class task_2 {
//    Напишите функцию printPrimeNums, которая выведет на экран все простые числа
//    в промежутке от 1 до 1000, каждое на новой строке.
//    Напишите свой код в методе printPrimeNums класса Answer.
    public class Printer {
        public  void main(String[] args) {
            Answer ans = new Answer();
            ans.printPrimeNums();
        }
    }

    class Answer {
        public void printPrimeNums() {
            for (int i = 2; i <= 1000; i++) {
                if (isPrime(i)) {
                    System.out.println(i);
                }
            }
        }

        public  boolean isPrime(int number) {
            for (int i = 2; i * i <= number; i++)
                if (number % i == 0) return false;
            return true;
        }
    }
}
