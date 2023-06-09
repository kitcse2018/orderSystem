package advancedWeb.orderSystem.controller;

import advancedWeb.orderSystem.dto.OrderDTO;
import advancedWeb.orderSystem.exception.customExceptions.OrderException;
import advancedWeb.orderSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getOrder")
    public ResponseEntity<Object> getOrder() {
        try{
            return ResponseEntity.ok().body(orderService.findAll());
        }catch(Exception e) {
            throw new OrderException("주문 조회 실패");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createOrder(@RequestBody OrderDTO orderDTO) {

        LocalTime now = LocalTime.now();
        if(now.isBefore(LocalTime.of(8, 0, 0)) && now.isAfter(LocalTime.of(23, 59, 59))) {
            throw new OrderException("주문 가능 시간이 아닙니다.");
        }

        if(!orderDTO.getIsContainMain()){
            throw new OrderException("메인 메뉴가 포함 되어야 합니다.");
        }

        if(orderDTO.getTotalPrice()<8000){
            throw new OrderException("최소 주문 금액은 8000원 입니다.");
        }

        orderDTO.setDelivery("ORDER");
        orderDTO.setCreationTime(LocalDateTime.now());
        orderService.createOrder(orderDTO);
        try {
            orderService.createOrder(orderDTO);
        } catch (Exception e) {
            throw new OrderException("주문 생성 불가");
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchOrder(@RequestParam("delivery") String delivery) {
        try {
            orderService.searchOrder(delivery);
        } catch (Exception e) {
            throw new OrderException("주문이 없습니다.");
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/accept")
    public ResponseEntity<Object> acceptOrder(@RequestParam("orderId") Long orderId) {
        try {
            orderService.acceptOrder(orderId);
        } catch (Exception e) {
            throw new OrderException("주문 수정 불가");
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
    public ResponseEntity<Object> cancelOrder(@RequestParam("orderId") Long orderId,
                                              @RequestBody OrderDTO orderDTO) {

        if(orderDTO.getDelivery().equals("DELIVERY")) {
            throw new OrderException("배달 중인 주문은 취소할 수 없습니다.");
        }

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
