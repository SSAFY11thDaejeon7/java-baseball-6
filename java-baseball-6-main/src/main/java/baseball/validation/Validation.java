package baseball.validation;

import baseball.constant.Constants;
import baseball.view.Message;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    public static void verifyException(List<Integer> input){
        hasDuplicateNumbers(input);
        invalidInput(input);
    }
    public static void hasDuplicateNumbers(List<Integer> input) {
        Set<Integer> set = new HashSet<>();

        for (Integer item : input) {
            if (!set.add(item)) {
                throw new IllegalArgumentException(Message.DUPLICATE_NUM);
            }
        }
    }
    public static void invalidInput(List<Integer> input) {
        if (input.size() != Constants.NUMBER_OF_BASEBALL) {
            throw new IllegalArgumentException(Message.INVALID_INPUT_MESSAGE);
        }
    }
    public static void invalidGame(int number) {
        if(number != 1 && number != 2){
            throw new IllegalStateException(Message.INVALID_GAME_NUMBER);
        }
    }

}
