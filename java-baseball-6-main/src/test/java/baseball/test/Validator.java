package baseball.test;

import baseball.controller.BaseballController;
import baseball.domain.Baseballs;
import baseball.service.BaseballService;
import baseball.validation.Validation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Validator {

    @Test
    public void 중복된_숫자_입력_예외처리() {
        List<Integer> input = List.of(1, 1, 3);
        Assertions.assertThatThrownBy(() -> Validation.hasDuplicateNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("같은 숫자 입력은 안됩니다.");
    }
    @Test
    void 세자리로_안넣었을_때_예외처리() {
        List<Integer> invalidInput = Arrays.asList(1, 2);
        assertThrows(IllegalArgumentException.class, () -> Validation.invalidInput(invalidInput));
    }

    @Test
    void 숫자가_아닌_문자입력_예외처리() {
        String input = "12A";
        assertThrows(IllegalArgumentException.class, () -> Baseballs.changeStrToList(input));
    }

    @Test
    void 게임_재시작_할때_올바르지않은_입력_예외처리() {
        assertThrows(IllegalStateException.class, () -> Validation.invalidGame(3));
    }
}
