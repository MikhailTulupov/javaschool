package butorin;

import java.util.Arrays;
import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        int[] array = new int[100000];
        long start, fin, elapsed;
        int id = 0;

        start = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
            Arrays.sort(array);
            System.out.print(array[i] + " ");
        }

        int num = (int) (Math.random() * 1000);
        System.out.println("\nЧисло для поиска: " + num);

        id = line(array, num);
        fin = System.currentTimeMillis();
        elapsed = fin - start;
        if (id < 0) {
            System.out.println("Ошибка");
        } else
            System.out.println("――――――Линейный поиск――――――\n" + "Элемент: " + array[id] + "\nId: " + id + "\nПрошло времени, мс: " + elapsed);

        id = binary(array, num);
        fin = System.currentTimeMillis();
        elapsed = fin - start;
        if (id < 0) {
            System.out.println("Ошибка");
        } else
            System.out.println("\n――――――Бинарный поиск――――――\n" + "Элемент: " + array[id] + "\nId: " + id + "\nПрошло времени, мс: " + elapsed);

        id = jump(array, num);
        fin = System.currentTimeMillis();
        elapsed = fin - start;
        if (id < 0) {
            System.out.println("Ошибка");
        } else
            System.out.println("\n――――――Поиск прыжками――――――\n" + "Элемент: " + array[id] + "\nId: " + id + "\nПрошло времени, мс: " + elapsed);
    }


    public static int line(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public static int binary(int[] arr, int number) {
        int lowID = 0;
        int highID = arr.length - 1;
        int Pos = -1;

        while (lowID <= highID) {
            int midID = (lowID + highID) / 2;
            if (number == arr[midID]) {
                Pos = midID;
                break;
            } else if (number < arr[midID]) {
                highID = midID - 1;
            } else if (number > arr[midID]) {
                lowID = midID + 1;
            }
        }
        return Pos;
    }

    public static int jump(int[] arr, int number) {
        int arrLenght = arr.length;
        int Step = (int) Math.sqrt(arr.length);
        int preStep = 0;

        while (arr[Math.min(Step, arrLenght) - 1] < number) {
            preStep = Step;
            Step += (int) (Math.sqrt(arrLenght));
            if (preStep >= arrLenght)
                return -1;
        }
        while (arr[preStep] < number) {
            preStep++;
            if (preStep == Math.min(Step, arrLenght))
                return -1;
        }
        if (arr[preStep] == number)
            return preStep;
        return -1;
    }

}