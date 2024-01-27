package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> numbers = new ArrayList<>();

    public Player(List<Integer> numbers) {
        this.numbers.addAll(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
