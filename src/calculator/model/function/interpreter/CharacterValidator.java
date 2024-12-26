package calculator.model.function.interpreter;

public sealed interface CharacterValidator permits MathCharacterValidator {
    boolean validateCharacter(char character);
}
