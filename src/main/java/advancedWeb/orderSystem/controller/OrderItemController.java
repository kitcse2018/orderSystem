package advancedWeb.orderSystem.controller;

import advancedWeb.orderSystem.exception.customExceptions.OrderItemException;
import advancedWeb.orderSystem.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/getOrderItem")
    public ResponseEntity<Object> getOrderItem() {
        try {
//            orderItemService.getOrderItem();
        } catch (Exception e) {
            throw new OrderItemException("주문 상품 조회 불가");
        }
        // ResponseEntity.ok().body(orderItem);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(OrderItemException.class)
    public ResponseEntity<Object> handleOrderItemException(OrderItemException e) {
        printExceptionInfo(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> exHandler(RuntimeException e){
        printExceptionInfo(e.getMessage());
        return ResponseEntity.badRequest().body("예기치 못한 오류가 발생했습니다.");
    }

    public void printExceptionInfo(String message){
        System.out.println("=============================================");
        System.out.println("OrderItemController printExceptionInfo");
        System.out.println("Exception message = " + message);
        System.out.println("=============================================");
    }
}
