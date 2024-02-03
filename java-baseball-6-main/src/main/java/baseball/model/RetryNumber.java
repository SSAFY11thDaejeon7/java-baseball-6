package baseball.model;

public class RetryNumber {
    private String retryNumber;

    public RetryNumber(String retryNumber) {
        checkRetryNumber(retryNumber);

        this.retryNumber = retryNumber;
    }

    public String getRetryNumber() {
        return retryNumber;
    }

    public static void checkRetryNumber(String number) throws IllegalArgumentException {
        if (!(number.equals("1") || number.equals("2"))) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
