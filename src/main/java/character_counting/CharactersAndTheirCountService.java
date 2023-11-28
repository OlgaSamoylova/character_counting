package character_counting;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Сервис преобразования строки в ее символы и их количества
 */
@Service
public class CharactersAndTheirCountService {

    /**
     * @param string получаем строку
     * @return возвращаем Map<Символ, Его количество вхождений в строку> упорядоченно по убыванию количества символов в строке
     */
    public Map<Character, Integer> getResult(String string) {
        Map<Character, Integer> result = new HashMap<>();
        char[] chars = string.toLowerCase().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (result.containsKey(chars[i])) {
                result.put(chars[i], result.get(chars[i]) + 1);
            } else {
                result.put(chars[i], 1);
            }
        }

        LinkedHashMap<Character, Integer> sortedResult = result.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedResult;
    }
}
