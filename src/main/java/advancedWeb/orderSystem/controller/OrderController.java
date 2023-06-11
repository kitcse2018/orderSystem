package advancedWeb.orderSystem.controller;

import advancedWeb.orderSystem.dto.OrderDTO;
import advancedWeb.orderSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
