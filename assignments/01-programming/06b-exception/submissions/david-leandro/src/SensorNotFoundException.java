public class SensorNotFoundException extends Exception {

    public SensorNotFoundException(String message) {
        super(message);
    }

    public SensorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
