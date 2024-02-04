package baseball.util;

import java.util.List;

public class BallCount {
    private final List<Integer> answerNumbers;
    private final List<Integer> userGuess;

    public BallCount(List<Integer> answerNumbers, List<Integer> userGuess) {
        this.answerNumbers = answerNumbers;
        this.userGuess = userGuess;
    }

    public String getHint() {
        String hint = "";
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (userGuess.get(i).equals(answerNumbers.get(i))) {
                strike++;
            } else if (answerNumbers.contains(userGuess.get(i))) {
                ball++;
            }
        }
        if (ball > 0) {
            hint += ball + "볼 ";
        }
        if (strike > 0) {
            hint += strike + "스트라이크";
        }
        return hint;
    }
}
