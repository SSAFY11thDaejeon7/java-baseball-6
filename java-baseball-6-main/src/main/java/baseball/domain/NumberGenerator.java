package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class NumberGenerator {

    private static final int NUMBERS_SIZE = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    private List<Integer> computer = new ArrayList<>();

    public NumberGenerator() {
        while (computer.size() < NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputer() {
        return computer;
    }
}
