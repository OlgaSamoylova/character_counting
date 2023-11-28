package character_counting;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class CharacterController {

    CharactersAndTheirCountService charactersAndTheirCountService;

    @PostMapping
    public Map<Character, Integer> countCharacter(@RequestBody UserString userString) {
        return charactersAndTheirCountService.getResult(userString.getString());
    }
}
