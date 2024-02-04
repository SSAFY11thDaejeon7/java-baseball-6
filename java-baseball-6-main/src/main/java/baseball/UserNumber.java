package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserNumber {

    static private final UserNumber instance = new UserNumber();
    private final Valid valid;
    private List<Integer> numbers = new ArrayList<>();

    public static UserNumber getInstance() {
        return instance;
    }

    private UserNumber() {
        valid = Valid.getInstance();
    }

    public List<Integer> getNumber() {
        return numbers;
    }

    private void setNumbers(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            this.numbers.add(numbers.charAt(i) - '0');
        }
    }

    public void reset() {
        numbers.clear();
    }

    public void save(String numbers) {
        if (valid.isNumber(numbers)) {
            setNumbers(numbers);
            return;
        }
        throw new IllegalArgumentException();
    }
}
