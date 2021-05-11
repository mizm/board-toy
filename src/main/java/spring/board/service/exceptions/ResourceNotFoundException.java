package spring.board.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("not found user");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
