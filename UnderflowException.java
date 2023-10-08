
public class UnderflowException extends Exception {
    public UnderflowException() {
        super("Underflow");
    }

    public UnderflowException(String message) {
        super(message);
    }

    public UnderflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
