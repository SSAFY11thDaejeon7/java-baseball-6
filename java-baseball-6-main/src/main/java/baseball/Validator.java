package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    private final static int INPUT_SIZE = 3;
    private final static String NUMBERS = "123456789";
    public final static String INPUT = "숫자를 입력해주세요 : ";
    public final static String INPUT_SIZE_ERROR = "입력의 길이는 3자리여야 합니다.";
    public final static String INPUT_TYPE_ERROR = "입력은 0을 제외한 숫자만 가능합니다.";
    public final static String INPUT_DUPLICATION_ERROR = "입력은 서로 다른 숫자만 가능합니다.";
    public final static String REPLAY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final static String REPLAY_TYPE_ERROR = "입력은 1 또는 2만 가능합니다.";


    public static List<Integer> inputValidationCheck() {
        System.out.print(INPUT);
        String input = Console.readLine();
        lengthCheck(input);
        for (int i = 0; i < INPUT_SIZE; i++) {
            String c = Character.toString(input.charAt(i));
            typeCheck(c);
            duplicationCheck(input, c);
        }
        return inputToArray(input);

    }

    public static void lengthCheck(String input) throws IllegalArgumentException {
        if (input.length() != INPUT_SIZE)
            throw new IllegalArgumentException(INPUT_SIZE_ERROR);
    }

    public static void typeCheck(String c) throws IllegalArgumentException {
        if (!NUMBERS.contains(c))
            throw new IllegalArgumentException(INPUT_TYPE_ERROR);
    }

    public static void duplicationCheck(String input, String c) {
        if (INPUT_SIZE - input.replace(c, "").length() != 1) {
            throw new IllegalArgumentException(INPUT_DUPLICATION_ERROR);
        }
    }

    public static List<Integer> inputToArray(String input) {
        List<Integer> result = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return result;
    }

    public static boolean replayValidationCheck() {
        System.out.println(REPLAY);
        String input = Console.readLine();
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException(REPLAY_TYPE_ERROR);
        }

        if (input.equals("1"))
            return true;

        return false;

    }
}
