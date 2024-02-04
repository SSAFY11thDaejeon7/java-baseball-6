package baseball.domain;

import baseball.constant.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Baseballs {
    private List<Baseball> baseballList;

    public Baseballs(List<Integer> numbers) {
        baseballList = numbers.stream()
                .map(this::createBaseball)
                .collect(Collectors.toList());
    }


    private Baseball createBaseball(Integer number) {
        return new Baseball(number);
    }

    public static List<Integer> changeStrToList(String input) {
        List<Integer> resultList = Arrays.stream(input.split("")).map(str -> {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                // 숫자로 변환 불가능 할 때, 예외 던지기
                throw new IllegalArgumentException("숫자 변환 불가능");
            }
        }).collect(Collectors.toList());
        return resultList;
    }

    public int getStrikeCount(List<Integer> numbers) {
        int strikeCount = 0;
        for (int i = 0; i < Constants.NUMBER_OF_BASEBALL; i++) {

            if (baseballList.get(i).getNumber() == numbers.get(i)) {
                strikeCount += 1;
            }
        }

        return strikeCount;
    }

    public int getBallCount(List<Integer> numbers) {
        int ballCount = 0;
        List<Integer> ballNumbers = new ArrayList<>();
        for (int i = 0; i < Constants.NUMBER_OF_BASEBALL; i++) {
            ballNumbers.add(baseballList.get(i).getNumber());
        }

        for (int i = 0; i < Constants.NUMBER_OF_BASEBALL; i++) {

            if (ballNumbers.contains(numbers.get(i)) && ballNumbers.get(i) != numbers.get(i)) {
                ballCount += 1;
            }
        }

        return ballCount;
    }

    public boolean isNothing(List<Integer> numbers) {
        List<Integer> ballNumbers = new ArrayList<>();
        for (int i = 0; i < Constants.NUMBER_OF_BASEBALL; i++) {
            ballNumbers.add(baseballList.get(i).getNumber());
        }

        for (int i = 0; i < Constants.NUMBER_OF_BASEBALL; i++) {
            if (ballNumbers.contains(numbers.get(i))) {
                return false;
            }
        }
        return true;
    }
}
