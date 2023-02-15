package dovgal;

import java.util.Arrays;
import java.util.Scanner;

public class dovgalTask2 {
    public static void main(String[] args) {
        int[] array;
        array = new int[100000];
        long start,finish,elapsed;
        int id = 0;

        start = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = (0 + (int) ((Math.random() * 1000) + 3));
            System.out.print(array[i] + " ");
        }

        Arrays.sort(array);
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\nНапишите свое число (0-1000):");
        int num = scan.nextInt();

        id = linearSearch(array,num);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        if(id<0){
            System.out.println("FAILED");
        }
        else
            System.out.println("Линейный поиск: \n" + "Прошло времени, мс: " + elapsed + "\nId: " + id + "\nЭлемент: " + array[id] + "\n");

        id = binarySearch(array, num);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        if(id<0){
            System.out.println("FAILED");
        }
        else
            System.out.println("Бинарный поиск: \n" + "Прошло времени, мс: " + elapsed + "\nId: " + id + "\nЭлемент: " + array[id] + "\n");


        id= jumpSearch(array,num);
        finish=System.currentTimeMillis();
        elapsed=finish-start;
        if (id<0){
            System.out.println("FAILED");
        }
        else
            System.out.println("Прыжковый поиск: \n" + "Прошло времени, мс: " + elapsed + "\nId: " + id  + "\nЭлемент: " + array[id] + "\n");

    }
    public static int linearSearch(int[] array, int num){

        for (int i = 0; i < array.length; i++){
            if (array[i]==num){
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] array, int num){
        int index = Integer.MAX_VALUE;
        int low=0;
        int high= array.length-1;


        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (array[mid] < num) {
                low = mid + 1;
            } else if (array[mid] > num) {
                high = mid - 1;
            } else if (array[mid] == num) {
                index = mid;
                break;
            }
        }
        return index;
    }


    public static int jumpSearch(int[] array, int num) {

        int arrayLength = array.length;
        int jumpStep = (int) Math.sqrt(array.length);
        int previousStep = 0;

        while (array[Math.min(jumpStep, arrayLength) - 1] < num) {
            previousStep = jumpStep;
            jumpStep += (int)(Math.sqrt(arrayLength));
            if (previousStep >= arrayLength)
                return -1;
        }
        while (array[previousStep] < num) {
            previousStep++;
            if (previousStep == Math.min(jumpStep, arrayLength))
                return -1;
        }

        if (array[previousStep] == num)
            return previousStep;
        return -1;
    }
}
