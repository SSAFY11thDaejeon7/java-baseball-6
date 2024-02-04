package baseball;

import java.util.List;

public class Announcement {
    public final static String BALL = "볼";
    public final static String STRIKE = "스트라이크";
    public final static String NOTHING = "낫싱";
    public final static String END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void announce(List<Integer> total) {
        final int ball = total.get(0);
        final int strike = total.get(1);
        if (strike == 3) {
            System.out.println(strike + STRIKE);
            System.out.println(END);
            return;
        }
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING);
            return;
        }
        if (ball == 0) {
            System.out.println(strike + STRIKE);
            return;
        }
        if (strike == 0) {
            System.out.println(ball + BALL);
            return;
        }
        System.out.println(ball + BALL + " " + strike + STRIKE);

    }

    public static boolean result(List<Integer> total) {
        if (total.get(1) == 3)
            return true;
        return false;
    }
}
