package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class PlayerNumber {
    private String playerNumber;

    public PlayerNumber(String playerNumber) {
        checkLength(playerNumber);
        checkIsDigit(playerNumber);
        checkDuplicate(playerNumber);

        this.playerNumber = playerNumber;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public static void checkLength(String word) throws IllegalArgumentException {
        if (word.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(입력값 3자리수)");
        }
    }

    public static void checkIsDigit(String word) throws IllegalArgumentException {
        for (int i=0; i<word.length(); i++) {
            checkIsDigitEach(word.charAt(i));
        }
    }

    private static void checkIsDigitEach(char c) throws IllegalArgumentException{
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(3자리 자연수가 아닙니다.)");
        }
    }

    private static void checkDuplicate(String word) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();
        for (int i=0; i<word.length(); i++) {
            set.add(word.charAt(i));
        }

        if (set.size() != word.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(중복된 숫자");
        }
    }

}
