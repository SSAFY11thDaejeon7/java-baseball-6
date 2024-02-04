package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String GAME_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String GAME_INPUT_RETRY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public String inputNumber(){
        System.out.print(GAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String inputRetry(){
        System.out.println(GAME_INPUT_RETRY);
        return Console.readLine();
    }

}
