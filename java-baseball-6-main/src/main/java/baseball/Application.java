package baseball;

import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String test = inputView.readNumbersView();
        System.out.println(test);
    }
}
