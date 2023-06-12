package advancedWeb.orderSystem.exception.customExceptions;

public class DiscountException extends RuntimeException{
    public DiscountException() {
        super();
    }

    public DiscountException(String message) {
        super(message);
    }
}
