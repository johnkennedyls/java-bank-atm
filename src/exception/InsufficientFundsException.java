package exception;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String errorMessage) {
        super(errorMessage);
    }
}
