package tuzov;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


@SuppressWarnings("unchecked")
public class Main {

    /**
     * @param list list to be converted to array
     * @param clazz Class of the list elements
     * @param <T> Type of array elements
     * @return array of the given type T
     */
    public static <T> T[] toArray(List<T> list, Class<?> clazz) {
        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, list.size());
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * @param array original array
     * @param filter function or lambda what will be applied to each element;
     *               it should return Boolean; so if True is returned, element will be added to filtered collection,
     *               otherwise - not
     * @param <T> Type of array elements
     * @return filtered array of the given type T
     */
    public static <T> T[] filter(T[] array, Function<T, Boolean> filter) {
        ArrayList<T> temp_list = new ArrayList<>();
        for (var obj : array){
            if (filter.apply(obj))
                temp_list.add(obj);
        }
        return toArray(temp_list, array.getClass().getComponentType());
    }
}