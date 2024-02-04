package baseball;

import java.util.List;

public class Game {
    public final static String START = "숫자 야구 게임을 시작합니다.";
    static boolean replay = false;

    public void start() {
        System.out.println(START);

        do {
            play();
        } while (replay);
    }

    public void play() {
        final List<Integer> COMPUTER = RandomNumber.setRandomNumbers();
        System.out.println(COMPUTER);
        boolean answer = false;

        while (!answer) {
            final List<Integer> USER = Validator.inputValidationCheck();
            List<Integer> total = BallCounter.sumTotal(COMPUTER, USER);
            Announcement.announce(total);
            answer = Announcement.result(total);
        }
        replay = Validator.replayValidationCheck();


    }

}
