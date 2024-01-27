package baseball.converter;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    private static final int NUMBERS_SIZE = 3;

    public static List<Integer> inputToNumbers(String input) {
        if (input.length() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("올바른 길이의 숫자를 입력해주세요.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (char numberChar : input.toCharArray()) {
            int number = Character.getNumericValue(numberChar);
            numbers.add(number);
        }

        return numbers;
    }

    public static int inputToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
    }
}
