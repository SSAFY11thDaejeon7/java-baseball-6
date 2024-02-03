package baseball.test;

import baseball.domain.Baseballs;
import baseball.service.BaseballService;
import baseball.util.RandomNumbersGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseballTest {

    @Test
    public void 스트라이크_개수_체크(){
        // Given
        List<Integer> originalList = Arrays.asList(1,2,3);
        Baseballs baseballs = new Baseballs(originalList);
        List<Integer> guessList = Arrays.asList(1,3,2);

        // When
        int strikeCount = baseballs.getStrikeCount(guessList);

        // Then
        assertEquals(1, strikeCount, "Expected 1 strike");
    }

    @Test
    public void 볼_개수_체크(){
        // Given
        List<Integer> originalList = Arrays.asList(1,2,3);
        Baseballs baseballs = new Baseballs(originalList);
        List<Integer> guessList = Arrays.asList(1,3,2);

        // When
        int strikeCount = baseballs.getBallCount(guessList);

        // Then
        assertEquals(2, strikeCount, "Expected 2 balls");
    }

    @Test
    public void 맞춘_개수_출력() {
        BaseballService baseballService = new BaseballService();
        Baseballs baseballs = new Baseballs(Arrays.asList(1, 2, 3));
        List<Integer> numbers = Arrays.asList(1, 3, 2);

        String hintMessage = baseballService.createHintMessage(baseballs, numbers);

        assertEquals("2볼 1스트라이크", hintMessage, "Expected hint message: 1스트라이크");
    }

    @Test void 정답_3스트라이크(){
        Baseballs computerNumber = new Baseballs(Arrays.asList(1, 2, 3));
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        boolean result = new BaseballService().isCorrect(computerNumber, numbers);

        assertTrue(result, "Expected result: true");
    }
}
