package baseball.controller;

import baseball.dto.ResultDTO;
import baseball.service.NumberBaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseballController {
    private final NumberBaseballService numberBaseballService;
    private final InputView inputView;
    private final OutputView outputView;

    public NumberBaseballController(){
        numberBaseballService = new NumberBaseballService();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void startGame(){
        numberBaseballService.initGame();
        outputView.printStartMessage();
        while ( true ){
            ResultDTO resultDTO = numberBaseballService.getChallengeResult(inputView.inputNumber());
            outputView.printResult(resultDTO);
            if ( numberBaseballService.isEnd(resultDTO)){
                outputView.printEndMessage();
                if(numberBaseballService.isGameExit(inputView.inputRetry())){
                    break;
                }
                numberBaseballService.initGame();
            }
        }
    }

}
