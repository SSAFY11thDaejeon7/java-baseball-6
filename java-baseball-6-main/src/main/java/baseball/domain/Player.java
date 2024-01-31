package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final int DUPLICATE_CHECK_ARRAY_SIZE = 10;
    private static final int DUPLICATE_CHECK_NUMBER = 0;
    private List<Integer> numbers = new ArrayList<>();

    public Player(List<Integer> numbers) {
        this.numbers.addAll(numbers);
        validateDuplicateNumbers();
    }

    private void validateDuplicateNumbers() {
        int[] duplicateCheckArray = new int[DUPLICATE_CHECK_ARRAY_SIZE];
        for (int number : numbers) {
            if (duplicateCheckArray[number] > DUPLICATE_CHECK_NUMBER) {
                throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
            }
            duplicateCheckArray[number]++;
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
