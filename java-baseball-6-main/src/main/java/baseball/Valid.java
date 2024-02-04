package baseball;

import java.util.regex.Pattern;

public class Valid {

    private String numbersPattern = "^[1-9]{3}$";
    private String resetPattern = "^[1-2]$";
    static private final Valid instance = new Valid();

    static Valid getInstance() {
        return instance;
    }

    private Valid() {
    }

    public boolean isNumber(String numbers) {
        return Pattern.matches(numbersPattern, numbers) && isDistance(numbers);
    }

    private static boolean isDistance(String numbers) {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (numbers.charAt(i) == numbers.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean isReset(String number) {
        return Pattern.matches(resetPattern, number);
    }
}
