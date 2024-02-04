package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumber {
    private String computerNumber;

    public ComputerNumber() {
        setComputerNumber();
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<3; i++) {
            sb.append(getRandomNumber());
        }
        computerNumber = sb.toString();
    }


    public static String getRandomNumber() {
        return String.valueOf(Randoms.pickNumberInRange(1,9));
    }
}
