package advancedWeb.orderSystem.exception.customExceptions;

public class MemberException extends RuntimeException{

    public MemberException() {
        super();
    }

    public MemberException(String message) {
        super(message);
    }
}
