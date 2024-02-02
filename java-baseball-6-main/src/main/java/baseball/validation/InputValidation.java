package baseball.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidation {

    public void hasDuplicateNumbers(Integer[] numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(Arrays.asList(numbers));
        if(uniqueNumbers.size() < numbers.length) {
            throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
        }
    }
}
