package baseball.model;

import baseball.util.AnswerNumber;
import baseball.util.NumberGenerator;

import java.util.List;

public class GameModel {
    private AnswerNumber answerNumber;

    public void generateRandomNumber() {
        this.answerNumber = new AnswerNumber(new NumberGenerator());
    }

    public List<Integer> getAnswerNumbers() {
        return answerNumber.getAnswerNumbers();
    }
}
