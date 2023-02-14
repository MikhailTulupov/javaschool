package stoskiyna;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class STCounterTest {
    STCounter stCounter;

    @BeforeEach
    public void init() {
        stCounter = new STCounter();
    }

    @Test
    public void emptyStringCountingTest() {
        String text = "";
        assertEquals(0, Arrays.stream(stCounter.wordCounter(text)).count());
    }

    @Test
    public void spaceInTextTest(){
        String text = "           ";
        assertEquals(0, Arrays.stream(stCounter.wordCounter(text)).count());
    }

    @Test
    public void correctNumberOfWords(){
        String text = " �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��";
        var arr = stCounter.wordCounter(text);
        assertEquals(5, Arrays.stream(stCounter.wordCounter(text)).count());
    }

    @Test
    public void test(){
        String[] testArray = {"��","��","��","��","��"};
        String text = "�� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��";
        var arr = stCounter.wordCounter(text);
        assertArrayEquals(Arrays.stream(testArray).toArray(), Arrays.stream(arr).toArray());
    }

    @Test
    public void test2(){
        String text = "�� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ";
        String[] testArray = {"��","��","��","��","��","��","��","��","��","��"};
        var arr = stCounter.wordCounter(text);
        assertEquals(10, Arrays.stream(arr).count());
        assertArrayEquals(Arrays.stream(testArray).toArray(), Arrays.stream(arr).toArray());
    }
}