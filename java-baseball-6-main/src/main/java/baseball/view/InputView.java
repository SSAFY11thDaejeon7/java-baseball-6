package baseball.view;

import baseball.domain.Baseballs;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public static List<Integer> gameInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String str = Console.readLine();
        return Baseballs.changeStrToList(str);
    }
}
