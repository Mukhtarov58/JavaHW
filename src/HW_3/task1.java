package HW_3;

import java.util.Arrays;

public class task1 {
    //    Внутри класса MergeSort напишите метод mergeSort, который принимает массив целых чисел "а"
//    и реализует алгоритм сортировки слиянием. Метод должен возвращать отсортированный массив.
    public static void main(String[] args) {
        int[] a;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{5, 1, 6, 2, 3, 4};
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        task1 answer = new task1();
        String itresume_res = Arrays.toString(answer.mergeSort(a));
        System.out.println(itresume_res);

    }

    static int[] mergeSort(int[] a) {
        if (a.length <= 1) {
            return a; // Если массив уже отсортирован или содержит 0 или 1 элемент, возвращаем его
        }

        // Разделяем массив на две половины
        int middle = a.length / 2;
        int[] left = Arrays.copyOfRange(a, 0, middle);
        int[] right = Arrays.copyOfRange(a, middle, a.length);

        // Рекурсивно сортируем каждую половину
        left = mergeSort(left);
        right = mergeSort(right);

        // Объединяем отсортированные половины
        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        // Слияние отсортированных половин
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        // Добавление оставшихся элементов, если таковые есть
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }

        return result;
    }
}





