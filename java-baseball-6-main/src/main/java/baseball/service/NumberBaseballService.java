package baseball.service;

import baseball.constant.Constant;
import baseball.dto.ResultDTO;
import baseball.entity.ComputerNumber;
import baseball.repository.LottoNumberRepository;
import baseball.validator.NumberValidator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberBaseballService {

    private final LottoNumberRepository lottoNumberRepository;

    public NumberBaseballService(){
        lottoNumberRepository = new LottoNumberRepository();
    }
    public void initGame(){
        lottoNumberRepository.setLottoNumber(new ComputerNumber(makeLottoNumbers()));
    }

    public List<Integer> makeLottoNumbers(){
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < Constant.GAME_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(Constant.NUMBER_START_RANGE, Constant.NUMBER_END_RANGE);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public ResultDTO getChallengeResult(String inputNumbers){
        List<Integer> numbers = transferToIntegerList(inputNumbers);
        List<Integer> lottoNumbers = lottoNumberRepository.getLottoNumber().getNumbers();
        int strike = (int) numbers.stream()
                .filter(lottoNumbers::contains)
                .count();
        int ball = numbers.size() - strike;
        return new ResultDTO(strike,ball);
    }

    public List<Integer> transferToIntegerList(String inputNumbers){
        NumberValidator.validateIsNumber(inputNumbers);
        List<Integer> numbers = inputNumbers.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
        NumberValidator.validateSize(numbers);
        NumberValidator.validateDuplicate(numbers);
        NumberValidator.validateRange(numbers);
        return numbers;
    }
}
