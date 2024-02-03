package baseball.service;

import baseball.domain.Baseballs;

import java.util.List;

public class BaseballService {

    public String createHintMessage(Baseballs baseballs, List<Integer> numbers) {
        if (baseballs.isNothing(numbers)) {
            return "없음";
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
            hintMsg.append(ballCount).append("볼");
        }
    }

    public void appendStrikeCount(StringBuilder hintMsg, int strikeCount) {
        if (strikeCount > 0) {
            hintMsg.append(strikeCount).append("스트라이크");
        }
    }

    public boolean isCorrect(Baseballs computerNumber, List<Integer> numbers) {
        int strikeCount = computerNumber.getStrikeCount(numbers);

        if (strikeCount == 3) {
            return true;
        }

        return false;
    }
}
