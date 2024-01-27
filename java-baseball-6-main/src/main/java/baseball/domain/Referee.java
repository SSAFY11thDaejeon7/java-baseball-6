package baseball.domain;

import java.util.List;

public class Referee {

    int strikeCount;
    int ballCount;

    public void compareNumbers(List<Integer> computerNumbers, List<Integer> userNumbers) {
        strikeCount = 0;
        ballCount = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);
            if (computerNumber == userNumber) {
                strikeCount++;
            }

            if (computerNumbers.contains(userNumber)) {
                ballCount++;
            }
        }

        ballCount -= strikeCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
