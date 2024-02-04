package baseball;

import baseball.model.GameModel;
import baseball.controller.GameController;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameModel game = new GameModel();
        GameView gameView = new GameView();
        GameController gameController = new GameController(game, gameView);
        gameController.startGame();
    }
}
