package stoskiyna;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  ласс дл€ работы с текстом, подсчет колличества слов в тексте.
 */
public class STCounter {

    /**
     * @param text исходный текст вводимый пользователем
     * @return массив часто повтор€ющихс€ слов
     * */
    public String[] wordCounter(String text) {

        text = text.replaceAll( "  ", " ").trim();
        if(text.isEmpty()) return new String[0];

        return  Arrays.stream(text.split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.toMap(key -> key, val -> 1, Integer::sum))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .sorted((e1, e2) -> {
                    if(e1.getValue() == e2.getValue())
                        return e1.getKey().compareTo(e2.getKey());
                    else
                        return e2.getValue().compareTo(e1.getValue());})
                .limit(10)
                .flatMap(e -> Stream.of(e.getKey()))
                .toArray(String[]::new);
    }
}