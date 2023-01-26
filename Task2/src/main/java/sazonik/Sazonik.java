package sazonik;

import java.util.Arrays;

public class Sazonik {

    public static void showinfo(String name, int id, long start, long stop) {
        System.out.printf("Число находится здесь: %d\n", id);
        System.out.printf("Найдено за такое время: %d мс\n", stop - start);
        System.out.printf("Использовался метод: %s\n", name);
    }

    public static int jmpsrch(int[] arr, int elem) {
        int sqrt_size = (int) (Math.sqrt(arr.length));
        int step = sqrt_size;
        int prev = 0;

        while (arr[Math.min(step, arr.length) - 1] < elem) {
            prev = step;
            step += sqrt_size;
            if (step >= arr.length)
                return -1;
        }

        while (arr[prev] < elem) {
            prev++;
            if (prev == Math.min(step, arr.length))
                return -1;
        }

        if (arr[prev] == elem)
            return prev;

        return -1;
    }


    public static int binsrch(int[] arr, int elem) {
        int f = 0;
        int l = arr.length - 1;

        while (f <= l) {
            int m = (f + l) / 2;
            if (arr[m] == elem) return m;

            else if (arr[m] < elem)
                f = m + 1;

            else if (arr[m] > elem)
                l = m - 1;
        }
        return -1;
    }

    public static int linsrch(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }

        Arrays.sort(arr);

        long start, stop;
        int num_to_find = (int) (Math.random() * 1000);
        int id;


        System.out.printf("Число %d\n", num_to_find);
        start = System.nanoTime();
        id = linsrch(arr, num_to_find);
        stop = System.nanoTime();
        showinfo("Линейный", id, start, stop);


        start = System.nanoTime();
        id = binsrch(arr, num_to_find);
        stop = System.nanoTime();
        showinfo("Бинарный", id, start, stop);

        start = System.nanoTime();
        id = jmpsrch(arr, num_to_find);
        stop = System.nanoTime();
        showinfo("Прыжками", id, start, stop);
    }

}
