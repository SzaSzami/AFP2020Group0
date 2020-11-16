package hu.uni.eku.tzs.service.exceptions;

public class GuestTooYoungException extends Exception
{
    public GuestTooYoungException() {}
    public GuestTooYoungException(String message) {
        super(message);
    }
    public GuestTooYoungException(Throwable cause) {
        super(cause);
    }
    public GuestTooYoungException(String message, Throwable cause) {
        super(message, cause);
    }
}
