package exeptions;

public class InsufficentFundsExeption extends Exception {
    public InsufficentFundsExeption(String message) {
        super(message);
    }
}