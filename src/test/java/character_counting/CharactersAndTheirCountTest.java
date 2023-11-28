package character_counting;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Тестирование логики приложения
 */
public class CharactersAndTheirCountTest {

    /**
     * проверка работы на непустой строке
     */
    @Test
    public void charCountTest() {
        String string = "aaaaabcccc";
        Map<Character, Integer> actual = new CharactersAndTheirCountService().getResult(string);
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 5);
        expected.put('c', 4);
        expected.put('b', 1);

        Assert.assertEquals(expected, actual);
    }

    /**
     * проверка работы на пустой строке
     */
    @Test
    public void charCountEmptyStringTest() {
        String string = "";
        Map<Character, Integer> actual = new CharactersAndTheirCountService().getResult(string);
        Map<Character, Integer> expected = new LinkedHashMap<>();

        Assert.assertEquals(expected, actual);
    }

}
