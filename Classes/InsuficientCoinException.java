// InsufficientCoinException.java
public class InsuficientCoinException extends Exception {
    public InsuficientCoinException() {
        super("Saldo insuficiente para comprar o booster.");
    }

    public InsuficientCoinException(String message) {
        super(message);
    }
}
