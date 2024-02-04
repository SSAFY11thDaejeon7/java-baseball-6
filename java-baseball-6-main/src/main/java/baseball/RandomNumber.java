package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    static private final RandomNumber instance = new RandomNumber();
    static int CNT = 3;

    static RandomNumber getInstance() {
        return instance;
    }

    private RandomNumber() {
    }

    public List<Integer> getNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}
