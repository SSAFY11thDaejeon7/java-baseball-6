package baseball.validator;

import baseball.constant.Constant;
import baseball.constant.errormessage.ComputerNumberError;
import baseball.constant.errormessage.PlayerInputError;
import baseball.entity.ComputerNumber;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidator {

    public static void validateIsNumber(String numbers) {
        char[] charArray = numbers.toCharArray();
        for (char number : charArray) {
            if (number < '1' || number > '9') {
                throw new IllegalArgumentException(PlayerInputError.PLAYER_NUMBER_WRONG_INPUT_NOT_INTEGER_MESSAGE);
            }
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != Constant.GAME_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ComputerNumberError.COMPUTER_NUMBER_WRONG_INPUT_SIZE_MESSAGE);
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != Constant.GAME_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ComputerNumberError.COMPUTER_NUMBER_WRONG_INPUT_DUPLICATE_MESSAGE);
        }
    }

    public static void validateRange(List<Integer> numbers){
        if ( numbers.stream()
                .anyMatch(number -> Constant.NUMBER_START_RANGE > number
                        || number > Constant.NUMBER_END_RANGE)){
            throw new IllegalArgumentException(ComputerNumberError.COMPUTER_NUMBER_WRONG_INPUT_RANGE_MESSAGE);
        }
    }

}
