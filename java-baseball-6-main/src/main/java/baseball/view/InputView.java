package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public String inputNumber(){
        return Console.readLine();
    }
}
