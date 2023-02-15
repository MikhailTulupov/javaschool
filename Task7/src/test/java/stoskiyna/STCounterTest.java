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
        String text = " àà ÀÀ ğğ ğğ àà Àà åå íí íí åå ğğ ïï ïï ïï ïï Ğğ";
        var arr = stCounter.wordCounter(text);
        assertEquals(5, Arrays.stream(stCounter.wordCounter(text)).count());
    }

    @Test
    public void test(){
        String[] testArray = {"àà","ïï","ğğ","åå","íí"};
        String text = "àà ÀÀ ğğ ğğ àà Àà åå íí íí åå ğğ ïï ïï ïï ïï Ğğ";
        var arr = stCounter.wordCounter(text);
        assertArrayEquals(Arrays.stream(testArray).toArray(), Arrays.stream(arr).toArray());
    }

    @Test
    public void test2(){
        String text = "àà ÀÀ ğğ ğğ àà Àà åå íí íí åå ğğ ïï ïï ïï ïï Ğğ òò òò îî ëë ëë ää ææ ïï àà ôô ìì ññ ôô ùù ğğ ";
        String[] testArray = {"àà","ïï","ğğ","åå","ëë","íí","òò","ôô","ää","ææ"};
        var arr = stCounter.wordCounter(text);
        assertEquals(10, Arrays.stream(arr).count());
        assertArrayEquals(Arrays.stream(testArray).toArray(), Arrays.stream(arr).toArray());
    }
}