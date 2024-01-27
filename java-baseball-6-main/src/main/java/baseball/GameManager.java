package baseball;

import baseball.converter.Converter;
import baseball.domain.NumberGenerator;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameManager {

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

            if (strike == 3) {
                break;
            }
        }
    }

    private void checkEndOrRestart() {
        String endOption = inputView.readEndOptionView();
        int endOptionNumber = Converter.inputToInt(endOption);
        if (endOptionNumber < 1 || endOptionNumber > 2) {
            throw new IllegalArgumentException("1또는 2를 입력하지 않았습니다.");
        }

        if (endOptionNumber == 1) {
            gameStart();
        }
    }
}
