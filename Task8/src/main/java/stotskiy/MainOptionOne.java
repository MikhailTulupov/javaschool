package stotskiy;

import java.util.Arrays;

/**
 * Class filtering elements in an array (generics are used)
 */
public class MainOptionOne {

    /**
     * @param filter filtering condition
     * @param arr    source array
     * @return filtered array
     */
    public static Object[] filter(Object[] arr, Filter filter) {
        int j = 0;
        Object [] arrNew = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (filter.apply(arr[i]))
                j++;
            else
                arrNew[i - j] = arr[i];
        }
        return Arrays.copyOf(arrNew, arrNew.length - j);
    }
}
