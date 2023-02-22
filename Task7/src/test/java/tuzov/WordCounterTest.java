package tuzov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class WordCounterTest {
    @Test
    public void countTest(){
        String text = "cat cat dog cat dog dog dog duck dog duck duck cat";
        var freqs = WordCounter.analyzeWordFreq(text);
        assertEquals("dog", freqs[0]);
        assertEquals("cat", freqs[1]);
        assertEquals("duck", freqs[2]);
    }

    @Test
    public void orderTest(){
        String text = "b b a a y y y x x x";
        var freqs = WordCounter.analyzeWordFreq(text);
        assertEquals("x", freqs[0]);
        assertEquals("y", freqs[1]);
        assertEquals("a", freqs[2]);
        assertEquals("b", freqs[3]);
    }

    @Test
    public void alphabetTest(){
        String text = "cba abc bca bac";
        var freqs = WordCounter.analyzeWordFreq(text);
        assertEquals("abc", freqs[0]);
        assertEquals("bac", freqs[1]);
        assertEquals("bca", freqs[2]);
        assertEquals("cba", freqs[3]);
    }
}