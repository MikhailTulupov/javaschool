package tuzov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FilterTest {

    @Test
    public void testObjectArray() {
        Object[] arr = {1, "", 2, "n", 4, 5, "l"};
        Object[] arrTest = {1, 2, 4, 5};
        Object[] filteredArr = Main.filter(arr, o -> !(o instanceof String));

        assertArrayEquals(arrTest, filteredArr);
    }

    @Test
    public void testStringInArray() {
        String[] arr = {"name", "year", "clown", "sleep", "she", "he"};
        String[] arrTest = {"she", "he"};
        String[] filteredArr = Main.filter(arr, s -> s.length() <= 3);

        assertArrayEquals(arrTest, filteredArr);
    }

    @Test
    public void testIntegerInArray() {
        Integer[] arr = {2, 1, 3, 6, 7, 9, 2};
        Integer[] arrTest = {2, 6, 2};
        Integer[] filteredArr = Main.filter(arr, i -> i % 2 > 0);
    }
}