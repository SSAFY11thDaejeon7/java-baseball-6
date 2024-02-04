package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BallCounter {
    static final int INIT_VALUE = 0;
    static final int LIST_SIZE = 3;


    public static List<Integer> sumTotal(List<Integer> computer, List<Integer> user) {
        int ball = INIT_VALUE;
        int strike = INIT_VALUE;

        for (int i = 0; i < LIST_SIZE; i++) {
            final int value = user.get(i);
            if (!computer.contains(value))
                continue;
            if (computer.indexOf(value) != user.indexOf(value)) {
                ball++;
                continue;
            }
            strike++;
        }
        return new ArrayList<>(Arrays.asList(ball, strike));
    }
}
