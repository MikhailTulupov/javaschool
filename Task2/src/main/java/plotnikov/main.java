package plotnikov;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input a number (0 - 1000): ");
        int num = in.nextInt();
        in.close();

        int[] arr = new int[100000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() * 1000) + 1);
            // System.out.println(arr[i]);
        }
        float start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                float finish = System.currentTimeMillis();
                float elapsed = finish - start;
                System.out.println("Число " + num + " найдено линейным способом, индекс = " + i + " Прошло времени, мс: " + elapsed);
                break;
            }
        }

        Arrays.sort(arr);
        int jumpStep = (int) (Math.sqrt(arr.length));
        int previousStep = 0;

        start = System.currentTimeMillis();

        while (arr[Math.min(jumpStep, arr.length) - 1] < num) {
            previousStep = jumpStep;
            jumpStep += (int) (Math.sqrt(arr.length));
            if (previousStep >= arr.length) {
                break;
            }
            while (arr[previousStep] < num) {
                previousStep++;
                if (previousStep == Math.min(jumpStep, arr.length)) {
                    break;
                }
            }
            if (arr[previousStep] == num) {
                float finish = System.currentTimeMillis();
                float elapsed = finish - start;
                System.out.println("Число " + num + " найдено сособом прыжками, индекс = " + previousStep + " Прошло времени, мс: " + elapsed);
            }
        }

        int low = 0;
        int high = arr.length - 1;

        start = System.currentTimeMillis();
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == num) {
                float finish = System.currentTimeMillis();
                float elapsed = finish - start;
                System.out.println("Число " + num + " найдено бинарным поиском , индекс = " + mid + " Прошло времени, мс: " + elapsed);
                break;
            } else if (arr[mid] < num)
                low = mid + 1;
            else if (arr[mid] > num)
                high = mid - 1;
        }
    }
}
