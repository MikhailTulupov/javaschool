package tuzov;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * class container for static analyzeWordFreq method
 */
public class WordCounter {

    /**
     * @param text - text
     * @return - String[] - first 10 words sorted im descending order (from most frequent to least frequent)
     *                      if text contains <10 unique words, only available word will be in array
     */
    public static String[] analyzeWordFreq(String text) {

        text = text.replaceAll( " {2}", " ").trim();
        if(text.isEmpty()) return new String[0];

        return  Arrays.stream(text.split(" "))
                // ignore case
                .map(String::toLowerCase)
                // {word_1: 0} -> {word_1: n}
                // {word_2: 0} -> {word_2: m}
                // ...
                // {word_j: 0} -> {word_j: i}
                .collect(Collectors.toMap(key -> key, val -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                // if values are equal stream will be sorted alphabetically
                .sorted((e0, e1) -> {
                    if(Objects.equals(e0.getValue(), e1.getValue()))
                        return e0.getKey().compareTo(e1.getKey());
                    else
                        return e1.getValue().compareTo(e0.getValue());
                })
                .flatMap(e -> Stream.of(e.getKey()))
                .toArray(String[]::new);
    }
}