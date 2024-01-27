package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> numbers = new ArrayList<>();

    public Player(List<Integer> numbers) {
        this.numbers.addAll(numbers);
        validateDuplicateNumbers();
    }

    private void validateDuplicateNumbers() {
        int[] duplicateCheckArray = new int[10];
        for (int number : numbers) {
            if (duplicateCheckArray[number] > 0) {
                throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
            }
            duplicateCheckArray[number]++;
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
