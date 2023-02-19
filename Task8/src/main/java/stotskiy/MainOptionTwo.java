package stotskiy;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Class filtering elements in an array (generics are used)
 */
@SuppressWarnings("unchecked")
public class MainOptionTwo {

    /**
     * @param <T>    the type of data that the method works with
     * @param filter filtering condition
     * @param arr    source array
     * @return filtered array
     */
    public static <T> T[] filter(T[] arr, Function<? super T, Boolean> filter) {
       T [] arrNew =  (T[]) new Object[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (filter.apply(arr[i]))
                j++;
            else
                arrNew[i - j] = arr[i];
        }
        return Arrays.copyOf(arrNew, arr.length - j);
    }
}
