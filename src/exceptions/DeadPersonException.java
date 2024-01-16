package exceptions;

public class DeadPersonException extends RuntimeException {

    public DeadPersonException(String message) {
        super(message);
    }
}
