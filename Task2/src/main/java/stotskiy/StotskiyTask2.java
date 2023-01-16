package stotskiy;

import java.util.Arrays;

public class StotskiyTask2 {
    public static void main(String[] args) {
        int[] array = new int[10000];
        long start, finish, elapsed;
        int randomNumber = (int) (Math.random() * 1000);
        int id = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        //Сортировка массива
        Arrays.sort(array);

        //Линейный поиск
        start = System.currentTimeMillis();
        id = LinearSearch(array, randomNumber);
        finish = System.currentTimeMillis();
        elapsed = start - finish;
        MessageFunction(id, elapsed, randomNumber, array);

        //Поиск прыжками
        start = System.currentTimeMillis();
        id = JumpSearch(array, randomNumber);
        finish = System.currentTimeMillis();
        elapsed = start - finish;
        MessageFunction(id, elapsed, randomNumber, array);

        //Поиск бинарный
        start = System.currentTimeMillis();
        id = BinarySearch(array, randomNumber);
        finish = System.currentTimeMillis();
        elapsed = start - finish;
        MessageFunction(id, elapsed, randomNumber, array);
    }

    public static int LinearSearch(int[] arr, int searchEl) {
        System.out.println("_____________Линейный поиск:______________");
        for (int i = 0; i < arr.length; i++) {
            //System.out.println(" " + String.valueOf(array[i]));
            if (arr[i] == searchEl) {
                return i;
            }
        }
        return -1;
    }

    public static int JumpSearch(int[] arr, int searchEl) {
        System.out.println("_____________Поиск прыжками:______________");
        int jumpStep = (int) Math.sqrt(arr.length);
        int previousStep = 0;

        while (arr[Math.min(jumpStep, arr.length) - 1] < searchEl) {
            previousStep = jumpStep;
            jumpStep += (int) Math.sqrt(arr.length);
            if (previousStep > arr.length) {
                return -1;
            }
        }
        while (arr[previousStep] < searchEl) {
            previousStep++;
            if (previousStep == Math.min(jumpStep, arr.length)) {
                return -1;
            }
        }
        if (arr[previousStep] == searchEl)
            return previousStep;
        return -1;
    }

    public static int BinarySearch(int[] arr, int searchEl) {
        System.out.println("_____________Бинарный:______________");
        int minIndexArray = 0;
        int maxIndexArray = arr.length - 1;

        while (minIndexArray < maxIndexArray) {
            int midIndexArray = (minIndexArray + maxIndexArray) / 2;

            if (arr[midIndexArray] == searchEl) {
                return midIndexArray;
            } else if (arr[midIndexArray] < searchEl) {
                minIndexArray = midIndexArray + 1;
            } else if (arr[midIndexArray] > searchEl) {
                maxIndexArray = midIndexArray - 1;
            }
        }
        return -1;
    }

    //Функция выдачи сообщений
    public static void MessageFunction(int id, long elapsed, int rN, int[] arr) {
        if (id == -1 || id == 0) {
            System.out.println("Числа не существует или оно не найдено");
        } else {
            System.out.println("Прошло времени: " + elapsed * (-1) + " мс | id = " + id + " |Число задуманное: " + rN + "| Число в массиве: " + arr[id]);
        }
    }


}

