package HW_1;

public class task_1 {
//    Вычислить n-ое треугольного число(сумма чисел от 1 до n).
//    Внутри класса Answer напишите метод countNTriangle, который принимает
//    число n и возвращает его n-ое треугольное число.
    public static void main(String[] args) {
        int n = 0;

        if (args.length == 0) {
            n = 4;
        } else {
            n = Integer.parseInt(args[0]);
        }

        // Вывод результата на экран
        Answer ans = new Answer();
        int itresume_res = ans.countNTriangle(n);
        System.out.println(itresume_res);
    }
}

class Answer {
    public int countNTriangle(int n){
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
