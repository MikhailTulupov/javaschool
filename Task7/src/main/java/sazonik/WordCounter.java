package sazonik;

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
                .map(String::toLowerCase)
                .collect(Collectors.toMap(key -> key, val -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                // if values are equal stream will be sorted alphabetically
                .sorted((elem1, elem2) -> {
                    if(Objects.equals(elem1.getValue(), elem2.getValue()))
                        return elem1.getKey().compareTo(elem2.getKey());
                    else
                        return elem2.getValue().compareTo(elem1.getValue());
                })
                .flatMap(elem -> Stream.of(elem.getKey()))
                .toArray(String[]::new);
    }
}
