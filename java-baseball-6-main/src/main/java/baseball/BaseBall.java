package baseball;

import java.util.List;

public class BaseBall {

    static private final BaseBall instance = new BaseBall();
    private final RandomNumber randomNumber;
    private final UserNumber userNumber;
    private List<Integer> numbers;

    static BaseBall getInstance() {
        return instance;
    }

    private BaseBall() {
        randomNumber = RandomNumber.getInstance();
        userNumber = UserNumber.getInstance();
        resetRandomNumber();
    }

    public int getStrikeCount() {
        int cnt = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (isStrike(i)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    private boolean isStrike(int i) {
        return numbers.get(i).equals(userNumber.getNumber().get(i));
    }

    public int getBallCount() {
        int cnt = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (isBall(i)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    private boolean isBall(int i) {
        int index = userNumber.getNumber().indexOf(numbers.get(i));
        return index != i && index != -1;
    }

    public boolean isEnd() {
        return getStrikeCount() == 3;
    }

    public void resetRandomNumber() {
        numbers = randomNumber.getNumbers();
    }
}
