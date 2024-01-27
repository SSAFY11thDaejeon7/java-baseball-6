package baseball.view;

public class OutputView {

    public void printGameStartView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printStrikeAndBallCountView(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }

        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }
}
