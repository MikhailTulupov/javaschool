package stotskiy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testObjectArray() {
        Object[] arr = {1, "", 2, "n", 4, 5, "l"};
        Object[] arrTest = {1, 2, 4, 5};
        var arrMainOpOne = MainOptionOne.filter(arr, o -> o instanceof String);

        var arrMainOpTwo = MainOptionTwo.filter(arr, a -> a instanceof String);
        assertArrayEquals(arrMainOpTwo, arrTest);
        assertArrayEquals(arrMainOpOne, arrTest);
    }

    @Test
    public void testStringInArray() {
        Object[] arr = {"name", "year", "clown", "sleep", "she", "he"};
        Object[] arrTest = {"she", "he"};
        var arrMainOpOne = MainOptionOne.filter(arr, o -> o.toString().length() > 3);
        var arrMainOpTwo = MainOptionTwo.filter(arr, a -> a.toString().length() > 3);
        assertArrayEquals(arrMainOpOne, arrTest);
        assertArrayEquals(arrMainOpTwo, arrTest);
    }

    @Test
    public void testIntegerInArray() {
        Object[] arr = {2, 1, 3, 6, 7, 9, 2};
        var arrayTest = new Object[]{2, 6, 2};
        var arrMainOpOne = MainOptionOne.filter(arr, new Filter() {
            @Override
            public boolean apply(Object o) {
                return (int) o % 2 > 0;
            }
        });
        var arrMainOpTwo = MainOptionTwo.filter(arr, a -> (int) a % 2 > 0);
        assertArrayEquals(arrMainOpOne, arrayTest);
        assertArrayEquals(arrMainOpTwo, arrayTest);
    }

    @Test
    public void testEqualityTwoMethods() {
        Object[] arr = {2, 1, 3, 6, 7, 9, 2};
        var arrMainOpOne = MainOptionOne.filter(arr, new Filter() {
            @Override
            public boolean apply(Object o) {
                return (int) o % 2 > 0;
            }
        });
        var arrMainOpTwo = MainOptionTwo.filter(arr, a -> (int) a % 2 > 0);
        assertArrayEquals(arrMainOpOne, arrMainOpTwo);
    }
}
