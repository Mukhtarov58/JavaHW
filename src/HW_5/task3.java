package HW_5;
import java.util.Arrays;

public class task3 {
//    Необходимо разработать программу для сортировки массива целых чисел с использованием
//    сортировки кучей (Heap Sort). Программа должна работать следующим образом:
//    Принимать на вход массив целых чисел для сортировки. Если массив не предоставлен,
//    программа использует массив по умолчанию.
//    Сначала выводить исходный массив на экран.
//    Затем применять сортировку кучей (Heap Sort) для сортировки элементов массива в порядке возрастания.
//    Выводить отсортированный массив на экран.
//    Ваше решение должно содержать два основных метода: buildTree,
//    который строит сортирующее дерево на основе массива, и heapSort,
//    который выполняет собственно сортировку кучей. Основная часть кода предоставлена вам.
//    Программа должна быть способной сортировать массив, даже если он состоит
//    из отрицательных чисел и имеет дубликаты.
public static void main(String[] args) {
    int[] initArray;

    if (args.length == 0) {
        initArray = new int[]{2, 10, 6, 19, 25, 13, 8, 4};
    } else {
        initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    System.out.println("Initial array:");
    System.out.println(Arrays.toString(initArray));
    HeapSort.heapSort(initArray, initArray.length);
    System.out.println("Sorted array:");
    System.out.println(Arrays.toString(initArray));
}
}
class HeapSort {
    public static void buildTree(int[] tree, int sortLength) {
        // Построение max heap
        for (int i = sortLength / 2 - 1; i >= 0; i--) {
            heapify(tree, sortLength, i);
        }
    }

    public static void heapSort(int[] sortArray, int sortLength) {
        // Построение max heap
        buildTree(sortArray, sortLength);

        // Сортировка кучей без отдельного метода heapify
        for (int i = sortLength - 1; i > 0; i--) {
            // Перемещаем корень (максимальный элемент) в конец массива
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;

            for (int j = 0; j < i; j++) {
                heapify(sortArray, i, j);
            }
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }
    }
}