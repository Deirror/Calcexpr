package calculator.model.function.interpreter;

import calculator.model.exception.InvalidCharacterException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.NoSuchElementException;

public final class MathInterpreter {
    private final HashMap<Character, BigDecimal> characterValuesMap;
    private final CharacterValidator mathCharacterValidator;

    public MathInterpreter(HashMap<Character, BigDecimal> characterValuesMap, CharacterValidator mathCharacterValidator) {
        this.characterValuesMap = characterValuesMap;
        this.mathCharacterValidator = mathCharacterValidator;
    }

    public void setCharacter(char character, BigDecimal number) {
        if(mathCharacterValidator.validateCharacter(character)) {
            characterValuesMap.put(character, number);
        } else {
            throw new InvalidCharacterException("Character is not a letter.");
        }
    }

    public BigDecimal getValue(char character) {
        if(characterValuesMap.containsKey(character)) {
            return characterValuesMap.get(character);
        } else {
            throw new NoSuchElementException("Character is not found.");
        }
    }
}
