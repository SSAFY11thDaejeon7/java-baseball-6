package baseball.view;

public class OutputView {

    private static final int ZERO_COUNT = 0;

    public void printGameStartView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printStrikeAndBallCountView(int strike, int ball) {
        if (strike == ZERO_COUNT && ball == ZERO_COUNT) {
            System.out.println("낫싱");
            return;
        }

        if (ball > ZERO_COUNT) {
            System.out.print(ball + "볼 ");
        }

        if (strike > ZERO_COUNT) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }

    public void printGameEndView() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
