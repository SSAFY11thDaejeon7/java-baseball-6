package baseball.domain;

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


    private Baseball createBaseball(Integer number){
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

    public int getStrikeCount(List<Integer> numbers){
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {

            if (baseballList.get(i).getNumber() == numbers.get(i)) {
                strikeCount += 1;
            }
        }

        return strikeCount;
    }
}
