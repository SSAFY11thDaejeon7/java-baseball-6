package baseball.service;

import baseball.constant.Constant;
import baseball.entity.ComputerNumber;
import baseball.repository.LottoNumberRepository;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

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

}
