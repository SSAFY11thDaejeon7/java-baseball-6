package baseball;

import baseball.controller.GameController;
import baseball.model.GameModel;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameModel gameModel = new GameModel();
        GameView gameView = new GameView();
        GameController gameController = new GameController(gameModel, gameView);
        gameController.startGame();
    }
}
