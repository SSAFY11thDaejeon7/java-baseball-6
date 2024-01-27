package baseball;

import baseball.converter.Converter;
import baseball.domain.NumberGenerator;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameManager {

    private static final int GAME_CLEAR_STRIKE_COUNT = 3;
    private static final int GAME_RESTART_NUMBER = 1;
    private static final int GAME_END_NUMBER = 2;

    private final InputView inputView;
    private final OutputView outputView;
    private Referee referee;

    public GameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        referee = new Referee();
    }

    public void gameStart() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> computerNumbers = numberGenerator.getComputer();

        outputView.printGameStartView();
        play(computerNumbers);
        outputView.printGameEndView();

        checkEndOrRestart();
    }

    private void play(List<Integer> computerNumbers) {
        while (true) {
            String input = inputView.readNumbersView();
            Player player = new Player(Converter.inputToNumbers(input));

            referee.compareNumbers(computerNumbers, player.getNumbers());
            int strike = referee.getStrikeCount();
            int ball = referee.getBallCount();
            outputView.printStrikeAndBallCountView(strike, ball);

            if (strike == GAME_CLEAR_STRIKE_COUNT) {
                break;
            }
        }
    }

    private void checkEndOrRestart() {
        String endOption = inputView.readEndOptionView();
        int endOptionNumber = Converter.inputToInt(endOption);
        if (endOptionNumber < GAME_RESTART_NUMBER || endOptionNumber > GAME_END_NUMBER) {
            throw new IllegalArgumentException("1또는 2를 입력하지 않았습니다.");
        }

        if (endOptionNumber == GAME_RESTART_NUMBER) {
            gameStart();
        }
    }
}
