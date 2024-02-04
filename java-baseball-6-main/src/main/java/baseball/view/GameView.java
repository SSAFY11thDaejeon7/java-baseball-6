package baseball.view;

import baseball.util.BallCount;
import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameView {
    public void displayStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> displayInput() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> result = Arrays.stream(Console.readLine().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        new InputValidator(result);
        return result;
    }

    public boolean displayHint(List<Integer> answerNumbers, List<Integer> userGuess) {
        BallCount ballCount = new BallCount(answerNumbers, userGuess);
        String hint = ballCount.getHint();
        if (hint.equals("3스트라이크")) {
            System.out.println(hint);
            return true;
        }
        if (hint.equals("")) {
            System.out.println("낫싱");
        } else {
            System.out.println(hint);
        }
        return false;
    }

    public int displaySuccess() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }
}
