package advancedWeb.orderSystem.service;

import advancedWeb.orderSystem.domain.Menu;
import advancedWeb.orderSystem.domain.Order;
import advancedWeb.orderSystem.domain.OrderItem;
import advancedWeb.orderSystem.dto.OrderDTO;
import advancedWeb.orderSystem.dto.OrderItemDTO;
import advancedWeb.orderSystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void createOrder(OrderDTO orderDTO) {
        Order order  = new Order();

        order.setDelivery(orderDTO.getDelivery());

        order = orderRepository.save(order);

        List<OrderItem> orderItemList = new ArrayList<>();

        for(OrderItemDTO orderItemDTO : orderDTO.getOrderItemDTOList()) {
            OrderItem orderItem = new OrderItem();
            Menu menu = new Menu();

            menu.setId(orderItemDTO.getMenuId());

            orderItem.setId(orderItemDTO.getId());
            orderItem.setOrder(order);
            orderItem.setMenu(menu);
            orderItem.setAmount(orderItemDTO.getAmount());

            orderItemList.add(orderItem);
        }
        order.setOrderItems(orderItemList);
        order.setId(order.getId());
    }

    @Transactional
    public void cancelOrder(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        String delivery = order.get().getDelivery();

        if(delivery.equals("주문")) {
            orderRepository.deleteById(orderId);
        } else {
            // 취소 안되는 로직 작성
        }
    }

    @Transactional
    public void searchOrder(String delivery) {
        orderRepository.findAllByDelivery(delivery);
    }

    @Transactional
    public void acceptOrder(Long orderId) {
        String delivery = "DELIVERY";
        orderRepository.updateOrderDelivery(orderId, delivery);
    }

    @Transactional
    public void updateOrderDelivery(Long orderId, String orderDelivery) {
        orderRepository.updateOrderDelivery(orderId, orderDelivery);
    }

    @Transactional
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Scheduled(fixedDelay = 60000)
    public void cancelPendingOrders() {
        List<Order> pendingOrders = orderRepository.findAllByDelivery("ORDER");

        for (Order order : pendingOrders) {
            LocalDateTime orderCreationTime = order.getCreationTime();
            LocalDateTime currentTime = LocalDateTime.now();

            Duration duration = Duration.between(orderCreationTime, currentTime);
            long minutesElapsed = duration.toMinutes();

            if (minutesElapsed >= 1) {
                orderRepository.delete(order);
            }
        }
    }
}
