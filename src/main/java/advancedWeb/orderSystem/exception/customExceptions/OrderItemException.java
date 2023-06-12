package advancedWeb.orderSystem.exception.customExceptions;

public class OrderItemException extends RuntimeException{

    public OrderItemException() {
        super();
    }

    public OrderItemException(String message) {
        super(message);
    }
}
