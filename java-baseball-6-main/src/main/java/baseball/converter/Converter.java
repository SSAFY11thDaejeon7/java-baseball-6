package baseball.converter;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    private static final int NUMBERS_SIZE = 3;

    public List<Integer> inputToNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (char number : input.toCharArray()) {
            numbers.add(Character.getNumericValue(number));
        }

        return numbers;
    }
}
