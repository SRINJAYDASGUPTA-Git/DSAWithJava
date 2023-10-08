public class OverflowException extends Exception {
    public OverflowException() {
        super("Overflow");
    }

    public OverflowException(String message) {
        super(message);
    }

    public OverflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
