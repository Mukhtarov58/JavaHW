package HW_4;

import java.util.LinkedList;

//В классе MyQueue реализуйте очередь с помощью LinkedList со следующими методами:
//
//        enqueue() - помещает элемент в конец очереди
//        dequeue() - возвращает первый элемент из очереди и удаляет его
//        first() - возвращает первый элемент из очереди, не удаляя
//        getElements() - возвращает все элементы в очереди
public class task2 {
    public static void main(String[] args) {
        MyQueue<Integer> queue;
        queue = new MyQueue<>();

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            queue.enqueue(1);
            queue.enqueue(10);
            queue.enqueue(15);
            queue.enqueue(5);
        } else {
            queue.enqueue(Integer.parseInt(args[0]));
            queue.enqueue(Integer.parseInt(args[1]));
            queue.enqueue(Integer.parseInt(args[2]));
            queue.enqueue(Integer.parseInt(args[3]));
        }

        System.out.println(queue.getElements());

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getElements());

        System.out.println(queue.first());
    }
}
class MyQueue<T> {
    private LinkedList<T> queue;

    public MyQueue() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(T element){
        queue.addLast(element);
    }

    public T dequeue(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.removeFirst();

    }

    public T first(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.getFirst();

    }

    public LinkedList<T> getElements() {
        return new LinkedList<>(queue);

    }
    private boolean isEmpty() {
        return queue.isEmpty();
    }
}

