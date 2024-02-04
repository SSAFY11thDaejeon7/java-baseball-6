package baseball.controller;

import baseball.model.GameModel;
import baseball.view.GameView;

import java.util.List;

public class GameController {
    private final GameModel gameModel;
    private final GameView gameView;

    public GameController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    public void startGame() {
        int option;
        gameView.displayStart();
        do {
            gameModel.generateRandomNumber();
            playGame();
            option = gameView.displaySuccess();
        } while (option == 1);
    }

    private void playGame() {
        while (true) {
            List<Integer> userGuess = gameView.displayInput();
            if (gameView.displayHint(gameModel.getAnswerNumbers(), userGuess))
                break;
        }
    }
}
