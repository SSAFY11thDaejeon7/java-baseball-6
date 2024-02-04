package baseball.util;

import java.util.List;

public class InputValidator {
    public InputValidator(List<Integer> userGuess) {
        if (userGuess.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
