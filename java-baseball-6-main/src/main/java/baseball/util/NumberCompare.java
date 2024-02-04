package baseball.util;

public class NumberCompare {
    private int ball;
    private int strike;

    public int getStrike() {
        return strike;
    }

    public int[] getNumberCompareResult(String playerNumber, String computerNumber) {
        resetCount();
        totalBallCount(playerNumber,computerNumber);
        strikeCount(playerNumber,computerNumber);
        finalBallCount();

        return new int[] {ball,strike};
    }

    public void resetCount() {
        ball = 0;
        strike = 0;
    }

    public void totalBallCount(String playerNumber, String computerNumber) {
        for (int i=0; i<playerNumber.length(); i++) {
            if (computerNumber.contains(Character.toString(playerNumber.charAt(i)))) {
                ball ++;
            }
        }
    }

    public void strikeCount(String playerNumber, String computerNumber) {
        for (int i=0; i<playerNumber.length(); i++) {
            if (playerNumber.charAt(i) == computerNumber.charAt(i)) {
                strike ++;
            }
        }
    }

    public void finalBallCount() {
        ball -= strike;
    }
}
