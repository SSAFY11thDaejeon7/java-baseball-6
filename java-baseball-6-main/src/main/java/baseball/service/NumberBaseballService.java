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
import java.util.stream.IntStream;

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

    public ResultDTO getChallengeResult(String inputNumbers) {
        List<Integer> numbers = transferToIntegerList(inputNumbers);
        List<Integer> lottoNumbers = lottoNumberRepository.getLottoNumber().getNumbers();

        int strike = (int)IntStream.range(0, Constant.GAME_NUMBERS_SIZE)
                .filter(i -> numbers.get(i).equals(lottoNumbers.get(i)))
                .count();
        int ball = (int)IntStream.range(0, Constant.GAME_NUMBERS_SIZE)
                .filter(i -> !numbers.get(i).equals(lottoNumbers.get(i)) && lottoNumbers.contains(numbers.get(i)))
                .count();

        return new ResultDTO(strike, ball);
    }

    public boolean isEnd(ResultDTO resultDTO){
        if ( resultDTO.getStrike() == 3 ){
            return true;
        }
        return false;
    }

    public boolean isGameExit(String number){
        NumberValidator.validateIsNumber(number);
        NumberValidator.validateIsCorrectNumber(number);
        if ( number.equals("1") ) return false;
        return true;
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
