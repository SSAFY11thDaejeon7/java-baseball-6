package baseball.util;

import java.util.List;

public class AnswerNumber {
    private final List<Integer> answerNumbers;

    public AnswerNumber(NumberGenerator numberGenerator) {
        this.answerNumbers = numberGenerator.getAnswerNumber();
    }

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }
}
