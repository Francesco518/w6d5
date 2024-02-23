package francescobuonocore.w6d5.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(long id) {
        super(id + " has not been found");
    }
    public NotFoundException(String message) {
        super(message);
    }
}
