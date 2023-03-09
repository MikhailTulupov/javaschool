package rodionov;

import java.util.Arrays;
import java.util.Scanner;

public class main {

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

        Scanner scan = new Scanner(System.in);
        System.out.println("\nВведите число для поиска: ");
        int num = scan.nextInt();


        id = line(array, num);
        fin = System.currentTimeMillis();
        elapsed = fin - start;
        if (id < 0) {
            System.out.println("Ошибка");
        } else
            System.out.println("Линейный поиск" + "\nПрошло времени, мс: " + elapsed + "\nId: " + id + "\nЭлемент: " + array[id]);

        id = binary(array, num);
        fin = System.currentTimeMillis();
        elapsed = fin - start;
        if (id < 0) {
            System.out.println("Ошибка");
        } else
            System.out.println("\nБинарный поиск" + "\nПрошло времени, мс: " + elapsed + "\nId: " + id + "\nЭлемент: " + array[id]);

        id = jump(array, num);
        fin = System.currentTimeMillis();
        elapsed = fin - start;
        if (id < 0) {
            System.out.println("Ошибка");
        } else
            System.out.println("\nПоиск прыжками" + "\nПрошло времени, мс: " + elapsed + "\nId: " + id + "\nЭлемент: " + array[id]);
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
        int lowIndex = 0;
        int highIndex = arr.length - 1;
        int elementPos = -1;

        while (lowIndex <= highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            if (number == arr[midIndex]) {
                elementPos = midIndex;
                break;
            } else if (number < arr[midIndex]) {
                highIndex = midIndex - 1;
            } else if (number > arr[midIndex]) {
                lowIndex = midIndex + 1;
            }
        }
        return elementPos;
    }

    public static int jump(int[] arr, int number) {
        int arrayLenght = arr.length;
        int jumpStep = (int) Math.sqrt(arr.length);
        int previousStep = 0;

        while (arr[Math.min(jumpStep, arrayLenght) - 1] < number) {
            previousStep = jumpStep;
            jumpStep += (int) (Math.sqrt(arrayLenght));
            if (previousStep >= arrayLenght)
                return -1;
        }
        while (arr[previousStep] < number) {
            previousStep++;
            if (previousStep == Math.min(jumpStep, arrayLenght))
                return -1;
        }
        if (arr[previousStep] == number)
            return previousStep;
        return -1;
    }
}
