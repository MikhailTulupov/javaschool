package Babihina;
import java.util.Arrays;

public class Main {
    public static int binaryPoisk(int[] array, int element) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int m = (start + end) / 2;
            if (array[m] == element) return m;

            else if (array[m] < element)
                start = m + 1;

            else if (array[m] > element)
                end = m - 1;
        }
        return -1;
    }

    public static int poiskPrizhkami(int[] array, int element) {
        int shag = (int) (Math.sqrt(array.length));
        int proshlye = 0;

        while (array[Math.min(shag, array.length) - 1] < element) {
            proshlye = shag;
            shag += (int) (Math.sqrt(array.length));
            if (shag >= array.length)
                return -1;
        }

        while (array[proshlye] < element) {
            proshlye++;
            if (proshlye == Math.min(shag, array.length))
                return -1;
        }

        if (array[proshlye] == element)
            return proshlye;

        return -1;
    }

    public static int lineyineyPoisk(int[] array, int elem) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elem)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] massiv = new int[100000];
        for (int i = 0; i < massiv.length; i++) {
            massiv[i] = (int) (Math.random() * 1000);
        }

        Arrays.sort(massiv);

        long start, finish;
        int chislo = 16;
        massiv[1620] = chislo;
        int index;

        start = System.nanoTime();
        index = lineyineyPoisk(massiv, chislo);
        finish = System.nanoTime();
        System.out.print("Lineyniy:");
        System.out.print("index: ");
        System.out.println(index);

        start = System.nanoTime();
        index = binaryPoisk(massiv, chislo);
        finish = System.nanoTime();
        System.out.print("Binarniy:");
        System.out.print("index: ");
        System.out.println(index);

        start = System.nanoTime();
        index = poiskPrizhkami(massiv, chislo);
        finish = System.nanoTime();
        System.out.print("Poisk prizhkami:");
        System.out.print("index: ");
        System.out.println(index);
    }
}