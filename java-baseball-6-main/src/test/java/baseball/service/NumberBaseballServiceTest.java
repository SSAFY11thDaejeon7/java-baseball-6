package baseball.service;

import baseball.validator.NumberValidator;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberBaseballServiceTest {

    private final NumberBaseballService numberBaseballService = new NumberBaseballService();

    @Test
    @DisplayName("게임 재시작 1 입력 시")
    void testIsGameExit_ValidInput_ReturnsFalse() {
        String validInput = "1";
        boolean result = numberBaseballService.isGameExit(validInput);
        assertFalse(result);
    }

    @Test
    @DisplayName("게임 재시작 3 입력 시")
    void testIsGameExit_InvalidInput_ReturnsTrue() {
        String invalidInput = "3"; // Assuming 3 is an invalid input
        assertThrows(IllegalArgumentException.class, () -> numberBaseballService.isGameExit(invalidInput));
    }

    @Test
    @DisplayName("게임 재시작 수가 아닌 문자열 입력 시")
    void testIsGameExit_InvalidNumberFormat_ThrowsException() {
        String invalidNumber = "abc"; // Invalid number format
        assertThrows(IllegalArgumentException.class, () -> numberBaseballService.isGameExit(invalidNumber));
    }

    @Test
    @DisplayName("숫자만 포함된 문자열 입력 시")
    void testValidateIsNumber_ValidInput_NoExceptionThrown() {
        String validInput = "123456";
        assertDoesNotThrow(() -> NumberValidator.validateIsNumber(validInput));
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 포함된 문자열 입력 시")
    void testValidateIsNumber_InvalidInput_ThrowsException() {
        String invalidInput = "12a34"; // Contains non-numeric character
        assertThrows(IllegalArgumentException.class, () -> NumberValidator.validateIsNumber(invalidInput));
    }

    @Test
    @DisplayName("입력한 문자열의 길이가 제한된 크기를 넘을 때")
    void testValidateSize_WrongSize_ThrowsException() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 5); // Incorrect size
        assertThrows(IllegalArgumentException.class, () -> NumberValidator.validateSize(invalidNumbers));
    }

    @Test
    @DisplayName("입력한 문자열 중 중복되는 숫자가 입력될 때")
    void testValidateDuplicate_DuplicateNumbers_ThrowsException() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 2, 3, 4); // Contains duplicates
        assertThrows(IllegalArgumentException.class, () -> NumberValidator.validateDuplicate(duplicateNumbers));
    }

    @Test
    @DisplayName("입력한 숫자들 중 제한 범위를 넘는 숫자가 포함될 때")
    void testValidateRange_OutOfRangeNumbers_ThrowsException() {
        List<Integer> outOfRangeNumbers = Arrays.asList(0, 5, 10); // Out of valid range
        assertThrows(IllegalArgumentException.class, () -> NumberValidator.validateRange(outOfRangeNumbers));
    }
}