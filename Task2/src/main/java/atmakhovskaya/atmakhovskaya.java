package atmakhovskaya;

import java.util.Arrays;
import java.util.Scanner;

public class atmakhovskaya {
    public static void main(String[] args) {
        int[] array;
        array = new int[100000];
        long start,fin,elapsed;
        int id = 0;

        start = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = ((int)(Math.random() * 1000));
            System.out.print(array[i] + " ");
        }
        Arrays.sort(array);
        Scanner scan = new Scanner(System.in);
        System.out.println("\nКакое число найти? ");
        int num = scan.nextInt();

        id = runLinearSearch(array,num);
        fin = System.currentTimeMillis();
        elapsed = fin - start;
        if(id<0){
            System.out.println("Ошибка");
        }
        else
            System.out.println("Линейный поиск: " + "Прошло времени, мс: " + elapsed + "Id: " + id + "Элемент: " + array[id]);

        id = runBinarySearch(array, num);
        fin = System.currentTimeMillis();
        elapsed = fin - start;
        if(id<0){
            System.out.println("Ошибка");
        }
        else
            System.out.println("Бинарный поиск: " + "Прошло времени, мс: " + elapsed + "Id: " + id + "Элемент: " + array[id]);


        id= runJumpSearch(array,num);
        fin=System.currentTimeMillis();
        elapsed=fin-start;
        if (id<0){
            System.out.println("Ошибочка");
        }
        else
            System.out.println("Прыжковый поиск: " + "Прошло времени, мс: " + elapsed + "Id: " + id  + "Элемент: " + array[id]);

    }
    public static int runLinearSearch(int[] array, int num){

        for (int i = 0; i < array.length; i++){
            if (array[i]==num){
            return i;
            }
        }
        return -1;
    }
    public static int runBinarySearch(int[] array, int num){
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


    public static int runJumpSearch(int[] array, int num) {

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

