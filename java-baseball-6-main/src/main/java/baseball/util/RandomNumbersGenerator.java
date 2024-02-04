package baseball.util;

import baseball.constant.Constants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbersGenerator {

    public static List<Integer> randomNumberGenerator() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Constants.NUMBER_OF_BASEBALL) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
