package baseball.repository;

import baseball.entity.ComputerNumber;

public class LottoNumberRepository {
    private ComputerNumber lottoNumber;

    public void setLottoNumber(ComputerNumber lottoNumber){
        this.lottoNumber = lottoNumber;
    }

    public ComputerNumber getLottoNumber(){
        return lottoNumber;
    }
}
