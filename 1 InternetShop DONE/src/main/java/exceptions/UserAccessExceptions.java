package exceptions;

public class UserAccessExceptions extends RuntimeException {
    public UserAccessExceptions(String message) {
        super(message);
    }
}