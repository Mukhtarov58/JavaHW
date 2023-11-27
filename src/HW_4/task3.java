package HW_4;
import java.util.ArrayDeque;
import java.util.Deque;
//В обычный калькулятор без логирования добавьте возможность отменить последнюю операцию.
//Отмена последней операции должна быть реализована следующим образом:
//если передан оператор '<' калькулятор должен вывести результат предпоследней операции.
public class task3 {
    public static void main(String[] args) {
        int a, b, c, d;
        char op, op2, undo;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
            c = 4;
            op2 = '+';
            d = 7;
            undo = '<';
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
            c = Integer.parseInt(args[3]);
            op2 = args[4].charAt(0);
            d = Integer.parseInt(args[5]);
            undo = args[6].charAt(0);
        }

        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, a, b);
        System.out.println(result);
        int result2 = calculator.calculate(op2, c, d);
        System.out.println(result2);
        int prevResult = calculator.calculate(undo, 0, 0);
        System.out.println(prevResult);
    }
}
class Calculator {
    private Deque<Integer> results;

    public Calculator() {
        this.results = new ArrayDeque<>();
    }

    public int calculate(char op, int a, int b) {
        int result = 0;
        if (op == '<') {
            return undo();
        }

        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
                break;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + op);
        }

        results.push(result);
        return result;
    }

    private int undo() {
        if (results.size() < 2) {
            throw new IllegalStateException("Not enough operations to undo");
        }

        results.pop(); // Discard the last result
        return results.peek(); // Return the previous result
    }
}