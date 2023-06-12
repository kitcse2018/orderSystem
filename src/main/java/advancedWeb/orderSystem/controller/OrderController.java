package advancedWeb.orderSystem.controller;

import advancedWeb.orderSystem.dto.OrderDTO;
import advancedWeb.orderSystem.exception.customExceptions.OrderException;
import advancedWeb.orderSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createOrder(OrderDTO orderDTO) {
        try {
            orderService.createOrder(orderDTO);
        } catch (Exception e) {
            throw new OrderException("주문 생성 불가");
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateOrderDelivery(@RequestParam("orderId") Long orderId,
                                                      @RequestParam("orderDelivery") String orderDelivery) {
        try {
            orderService.updateOrderDelivery(orderId, orderDelivery);
        } catch (Exception e) {
            throw new OrderException("주문 수정 불가");
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<Object> cancelOrder(@RequestParam("orderId") Long orderId) {
        try {
            orderService.cancelOrder(orderId);
        } catch (Exception e) {
            throw new OrderException("주문 삭제 불가");
        }
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<Object> handleOrderException(OrderException e) {
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
        System.out.println("OrderController printExceptionInfo");
        System.out.println("Exception message = " + message);
        System.out.println("=============================================");
    }
}
