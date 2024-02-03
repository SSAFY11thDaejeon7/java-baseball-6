package baseball.test;

import baseball.domain.Baseballs;
import baseball.util.RandomNumbersGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballTest {

    @Test
    public void 스트라이크_개수_체크(){
        // Given
        List<Integer> originalList = new ArrayList<>();
        originalList.add(1);
        originalList.add(2);
        originalList.add(3);

        Baseballs baseballs = new Baseballs(originalList);

        List<Integer> guessList = new ArrayList<>();
        guessList.add(1);
        guessList.add(3);
        guessList.add(2);

        // When
        int strikeCount = baseballs.getStrikeCount(guessList);

        // Then
        assertEquals(1, strikeCount, "Expected 1 strike");
    }
}
