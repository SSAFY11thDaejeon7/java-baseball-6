package baseball.view;

import baseball.domain.Baseballs;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public static List<Integer> gameInput() {
        System.out.print(Message.NUMERIC_INPUT_MESSAGE);
        String str = Console.readLine();
        return Baseballs.changeStrToList(str);
    }

    public static int endGame() {
        System.out.println(Message.WIN_MESSAGE);
        System.out.println(Message.MENU_PROMPT);

        String userInput = Console.readLine();
        int restartType = Integer.parseInt(userInput);

        return restartType;
    }
}
