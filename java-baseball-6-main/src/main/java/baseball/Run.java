package baseball;

import java.util.Scanner;

public class Run {

    private final Ui ui;
    private final BaseBall baseBall;
    private final UserNumber userNumber;

    private final Valid valid;

    static private final Run instance = new Run();

    static Run getInstance() {
        return instance;
    }

    private Run() {
        ui = Ui.getInstance();
        baseBall = BaseBall.getInstance();
        userNumber = UserNumber.getInstance();
        valid = Valid.getInstance();
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        int state = 1;

        while (state == 1) {
            ui.printStart();
            ui.input();
            userNumber.save(sc.next());
            ui.printResult(baseBall.getBallCount(), baseBall.getStrikeCount());

            if (baseBall.isEnd()) {
                ui.printEnd();
                ui.reset();
                baseBall.resetRandomNumber();
                state = getState(sc.next());
            }
            userNumber.reset();
        }

    }

    private int getState(String state) {
        if (valid.isReset(state)) {
            return Integer.parseInt(state);
        }
        throw new IllegalArgumentException();
    }
}
