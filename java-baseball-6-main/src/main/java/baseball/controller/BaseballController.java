package baseball.controller;

import baseball.domain.Baseballs;
import baseball.service.BaseballService;
import baseball.util.RandomNumbersGenerator;
import baseball.validation.Validation;
import baseball.view.InputView;
import baseball.view.Message;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private Baseballs baseballGame;
    private final BaseballService baseballService;
    private boolean stopGame = false;

    public BaseballController(){
        baseballService =  new BaseballService();
        baseballGame = new Baseballs(RandomNumbersGenerator.randomNumberGenerator());
    }
    public void run() {
        System.out.println(Message.START_GAME_MESSAGE);
        playGame();
    }

    public void playGame(){
        while (!stopGame) {
            List<Integer> userInput = InputView.gameInput();
            Validation.verifyException(userInput);
            String hintMessage = baseballService.createHintMessage(baseballGame, userInput);
            OutputView.printHintMessage(hintMessage);
            baseballGame = manageGameResult(baseballGame, userInput);
        }
    }

    private Baseballs manageGameResult(Baseballs baseballGame, List<Integer> userInput) {
        if (baseballService.isCorrect(baseballGame, userInput)) {
            int gameType = InputView.endGame();
            Validation.invalidGame(gameType);

            if (gameType == 1) {
                baseballGame = new Baseballs(RandomNumbersGenerator.randomNumberGenerator());
            }
            if (gameType == 2) {
                stopGame = true;
            }
        }

        return baseballGame;
    }
}
