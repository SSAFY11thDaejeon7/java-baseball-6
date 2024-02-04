package baseball.view;

import baseball.constant.Constant;
import baseball.dto.ResultDTO;
import java.util.StringJoiner;

public class OutputView {
    private static final String START_MESSAGE = "숫자야구게임을 시작합니다.";
    private static final String END_MESSAGE = Constant.GAME_NUMBERS_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printStartMessage(){
        System.out.println(START_MESSAGE);
    }

    public void printEndMessage(){
        System.out.println(END_MESSAGE);
    }

    public void printResult(ResultDTO resultDTO){
        StringJoiner sj = new StringJoiner(" ");
        if ( resultDTO.getBall() > 0 ){
            sj.add(resultDTO.getBall()+"볼");
        }
        if ( resultDTO.getStrike() > 0 )
        {
            sj.add(resultDTO.getStrike()+"스트라이크");
        }
        if ( resultDTO.getStrike() == 0 && resultDTO.getBall() == 0 ){
            sj.add("낫싱");
        }
        String result = sj.toString();
        System.out.println(result);
    }

}
