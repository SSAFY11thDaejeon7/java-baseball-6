package baseball.test;

import baseball.validation.InputValidation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Validator {

    @Test
    public void 중복된_숫자_입력_예외처리() {
        Integer[] input = {1,1,2};
        InputValidation iv = new InputValidation();
        Assertions.assertThatThrownBy(() -> iv.hasDuplicateNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 중복될 수 없습니다.");
    }
}
