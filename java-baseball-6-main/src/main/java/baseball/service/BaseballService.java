package baseball.service;

import baseball.constant.Constants;
import baseball.domain.Baseballs;
import baseball.view.Message;

import java.util.List;

public class BaseballService {

    public String createHintMessage(Baseballs baseballs, List<Integer> numbers) {
        if (baseballs.isNothing(numbers)) {
            return Message.NOTHING;
        }

        int ballCount = baseballs.getBallCount(numbers);
        int strikeCount = baseballs.getStrikeCount(numbers);
        StringBuilder hintMsg = createBallAndStrikeHint(ballCount, strikeCount);

        return hintMsg.toString();
    }

    public StringBuilder createBallAndStrikeHint(int ballCount, int strikeCount) {
        StringBuilder hintMsg = new StringBuilder();

        appendBallCount(hintMsg, ballCount);
        if (ballCount > 0 && strikeCount > 0) {
            hintMsg.append(" ");
        }
        appendStrikeCount(hintMsg, strikeCount);

        return hintMsg;
    }

    public void appendBallCount(StringBuilder hintMsg, int ballCount) {
        if (ballCount > 0) {
            hintMsg.append(ballCount).append(Message.BALL);
        }
    }

    public void appendStrikeCount(StringBuilder hintMsg, int strikeCount) {
        if (strikeCount > 0) {
            hintMsg.append(strikeCount).append(Message.STRIKE);
        }
    }

    public boolean isCorrect(Baseballs computerNumber, List<Integer> numbers) {
        int strikeCount = computerNumber.getStrikeCount(numbers);

        if (strikeCount == Constants.NUMBER_OF_BASEBALL) {
            return true;
        }

        return false;
    }
}
