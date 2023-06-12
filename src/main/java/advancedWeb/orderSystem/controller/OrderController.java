package advancedWeb.orderSystem.controller;

import advancedWeb.orderSystem.dto.OrderDTO;
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

        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateOrderDelivery(@RequestParam("orderId") Long orderId,
                                                      @RequestParam("orderDelivery") String orderDelivery) {
        try {
            orderService.updateOrderDelivery(orderId, orderDelivery);
        } catch (Exception e) {

        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<Object> cancelOrder(@RequestParam("orderId") Long orderId) {
        try {
            orderService.cancelOrder(orderId);
        } catch (Exception e) {

        }
        return ResponseEntity.ok().build();
    }
}
