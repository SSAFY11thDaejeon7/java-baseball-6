package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class RandomNumber {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;

    public static List<Integer> setRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int num = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;

    }
}
