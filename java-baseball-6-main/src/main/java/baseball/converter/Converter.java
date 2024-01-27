package baseball.converter;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    private static final int NUMBERS_SIZE = 3;

    public static List<Integer> inputToNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (char number : input.toCharArray()) {
            numbers.add(Character.getNumericValue(number));
        }

        return numbers;
    }

    public static int inputToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하지 않았습니다.");
        }
    }
}
