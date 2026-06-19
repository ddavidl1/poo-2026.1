public class InvalidReadingException extends Exception {

    public InvalidReadingException(String message) {
        super(message);
    }

    public InvalidReadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
