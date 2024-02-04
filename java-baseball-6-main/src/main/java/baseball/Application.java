package baseball;

import baseball.controller.Controller;
import baseball.model.RetryNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printGameStart();
        do {
            Controller controller = new Controller();
            controller.startBaseballGame();
        } while(askRetry());
    }

    public static boolean askRetry() {
        RetryNumber retryNumber = new RetryNumber(InputView.setRetryNumber());

        if (retryNumber.getRetryNumber().equals("1")) {
            return true;
        }
        return false;
    }
}
