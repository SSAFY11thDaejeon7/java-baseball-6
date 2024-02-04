package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {
    private final ComputerNumber computer;
    private static PlayerNumber player;
    private final Validator validator;

    public Controller() {
        computer = new ComputerNumber();
        validator = new Validator();
    }

    public void startBaseballGame() {
        do {
            getPlayerNumberInput();
            printCount(getNumberCompare());
        } while(!isGameVictory());
    }

    public void getPlayerNumberInput() {
        player = new PlayerNumber(InputView.setUserNumber());
    }

    public int[] getNumberCompare() {
        return validator.getNumberCompare(player.getPlayerNumber(), computer.getComputerNumber());
    }

    public void printCount(int[] count) {
        printBallCount(count);
        printStrikeCount(count);
        printNothing(count);
    }

    public static void printBallCount(int[] count) {
        if (count[0] == 0) return;
        if (count[1] > 0) {
            OutputView.printCount(count[0]);
            OutputView.printBallStrikeMessage();
        }
        if (count[1] == 0) {
            OutputView.printCount(count[0]);
            OutputView.printBallMessage();
        }

    }

    public static void printStrikeCount(int[] count) {
        if (count[1] > 0) {
            OutputView.printCount(count[1]);
            OutputView.printStrikeMessage();
        }
    }

    public static void printNothing(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            OutputView.printNothingMessage();
        }
    }

    public boolean isGameVictory() {
        if (validator.isThreeStrike()) {
            OutputView.printGameVictoryMessage();
            return true;
        }
        return false;
    }

}
