package sazonik;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    public void countTest(){
        String text = "top top top net net top net net sic sic net";
        var freqs = WordCounter.analyzeWordFreq(text);
        assertEquals("top", freqs[0]);
        assertEquals("net", freqs[1]);
        assertEquals("sic", freqs[2]);
    }

    @Test
    public void orderTest(){
        String text = "h h h u u u t t r r";
        var freqs = WordCounter.analyzeWordFreq(text);
        assertEquals("h", freqs[0]);
        assertEquals("u", freqs[1]);
        assertEquals("t", freqs[2]);
        assertEquals("r", freqs[3]);
    }

    @Test
    public void alphabetTest(){
        String text = "bca bac cba abc";
        var freqs = WordCounter.analyzeWordFreq(text);
        assertEquals("abc", freqs[0]);
        assertEquals("bac", freqs[1]);
        assertEquals("bca", freqs[2]);
        assertEquals("cba", freqs[3]);
    }
}