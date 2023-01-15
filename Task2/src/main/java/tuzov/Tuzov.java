package tuzov;

import java.util.Arrays;

public class Tuzov {
    public static int binarySearch(int[] arr, int elem) {
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


    public static int jumpSearch(int[] arr, int elem) {
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


    public static int linearSearch(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] bigarr = new int[100000];
        for (int i = 0; i < bigarr.length; i++) {
            bigarr[i] = (int) (Math.random() * 1000);
        }

        Arrays.sort(bigarr);

        long start, stop;
        int num_to_find = (int) (Math.random() * 1000);
        int elemid;

        System.out.printf("Trying to find %d\n", num_to_find);
        System.out.println("====Linear====");
        start = System.nanoTime();

        elemid = linearSearch(bigarr, num_to_find);
        System.out.printf("arr[%d] = %d\n", elemid, num_to_find);

        stop = System.nanoTime();
        System.out.printf("Elapsed: %d ns\n", stop - start);

        // --------------------------------------------------------------------------------

        System.out.println("====Binary====");
        start = System.nanoTime();

        elemid = binarySearch(bigarr, num_to_find);
        System.out.printf("arr[%d] = %d\n", elemid, num_to_find);

        stop = System.nanoTime();
        System.out.printf("Elapsed: %d ns\n", stop - start);

        // --------------------------------------------------------------------------------

        System.out.println("====Jump====");
        start = System.nanoTime();

        elemid = jumpSearch(bigarr, num_to_find);
        System.out.printf("arr[%d] = %d\n", elemid, num_to_find);

        stop = System.nanoTime();
        System.out.printf("Elapsed: %d ns\n", stop - start);

    }
}