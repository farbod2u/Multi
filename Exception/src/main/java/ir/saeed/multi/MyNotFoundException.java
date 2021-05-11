package ir.saeed.multi;

public class MyNotFoundException extends RuntimeException {
    public MyNotFoundException(String message) {
        super(message);
    }

    public MyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
