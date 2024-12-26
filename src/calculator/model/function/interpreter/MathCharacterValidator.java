package calculator.model.function.interpreter;

public final class MathCharacterValidator implements CharacterValidator {
    @Override
    public boolean validateCharacter(char character) {
        return Character.isLetter(character);
    }
}
