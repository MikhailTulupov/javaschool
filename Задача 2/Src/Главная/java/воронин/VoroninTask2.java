package voronin;

import java.util.Arrays;
import java.util.Scanner;

public class VoroninTask2 {
    public static void main(String ar[]) {
        int n = 10000;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        int input = sc.nextInt();

        getCurrentTimeLinearSearch(array, input);
        Arrays.sort(array);
        getCurrentTimeJumpSearch(array, input);
        getCurrentTimeBinarySearch(array, input);
    }

    public static void getCurrentTimeLinearSearch(int[] array, int inputNumber) {
        System.out.println("___LinearSearch___");

        long start, finish, elapsed;
        start = System.currentTimeMillis();

        int iter = linearSearch(array, inputNumber);

        finish = System.currentTimeMillis();
        elapsed = start - finish;
        output(iter, inputNumber, array);
        System.out.println("Прошло времени, мс: " + elapsed);

    }

    public static void getCurrentTimeJumpSearch(int[] array, int inputNumber) {
        System.out.println("___JumpSearch___");

        long start, finish, elapsed;
        start = System.currentTimeMillis();

        int iter = jumpSearch(array, inputNumber);

        finish = System.currentTimeMillis();
        elapsed = start - finish;
        output(iter, inputNumber, array);
        System.out.println("Прошло времени, мс: " + elapsed);
    }

    public static void getCurrentTimeBinarySearch(int[] array, int inputNumber) {
        System.out.println("___BinarySearch___");

        long start, finish, elapsed;
        start = System.currentTimeMillis();

        int iter = binarySearch(array, inputNumber);

        finish = System.currentTimeMillis();
        elapsed = start - finish;
        output(iter, inputNumber, array);
        System.out.println("Прошло времени, мс: " + elapsed);
    }

    public static void output(int iter, int iN, int[] array) {
        if (iter != -1) {
            System.out.println("id = " + iter + " |Число веденое: " + iN + "| Число в массиве: " + array[iter]);
        } else {
            System.out.println("Числа не существует или оно не найдено");
        }
    }


    public static int linearSearch(int[] array, int searchElement) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchElement) {
                return i;
            }
        }
        return -1;
    }

    public static int jumpSearch(int[] array, int searchElement) {
        int step = (int) Math.sqrt(array.length);
        int prev = 0;

        while (array[Math.min(step, array.length) - 1] < searchElement) {
            prev = step;
            step += (int) Math.sqrt(array.length);
            if (prev > array.length) {
                return -1;
            }
        }
        while (array[prev] < searchElement) {
            prev++;
            if (prev == Math.min(step, array.length)) {
                return -1;
            }
        }
        if (array[prev] == searchElement)
            return prev;
        return -1;
    }

    public static int binarySearch(int[] array, int searchElement) {

        int minIndex = 0;
        int maxIndex = array.length - 1;

        while (minIndex < maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;

            if (array[midIndex] == searchElement) {
                return midIndex;
            } else if (array[midIndex] < searchElement) {
                minIndex = midIndex + 1;
            } else if (array[midIndex] > searchElement) {
                maxIndex = midIndex - 1;
            }
        }
        return -1;
    }
}
