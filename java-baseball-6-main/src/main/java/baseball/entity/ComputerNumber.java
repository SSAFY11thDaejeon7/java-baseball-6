package baseball.entity;

import baseball.validator.NumberValidator;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private final List<Integer> numbers;

    public ComputerNumber(List<Integer> numbers){
        NumberValidator.validateSize(numbers);
        NumberValidator.validateDuplicate(numbers);
        NumberValidator.validateRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return new ArrayList<>(numbers);
    }

}
