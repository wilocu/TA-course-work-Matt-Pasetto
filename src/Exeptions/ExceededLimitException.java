package Exeptions;

public class ExceededLimitException extends Exception {
    public ExceededLimitException(String message) {
        super(message);
    }
}