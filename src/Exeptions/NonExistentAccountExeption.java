package Exeptions;

public class NonExistentAccountExeption extends Exception {
    public NonExistentAccountExeption(String message) {
        super(message);
    }
}