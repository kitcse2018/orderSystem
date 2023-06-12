package advancedWeb.orderSystem.service;

import advancedWeb.orderSystem.domain.Discount;
import advancedWeb.orderSystem.domain.Menu;
import advancedWeb.orderSystem.domain.Order;
import advancedWeb.orderSystem.domain.OrderItem;
import advancedWeb.orderSystem.dto.OrderDTO;
import advancedWeb.orderSystem.dto.OrderItemDTO;
import advancedWeb.orderSystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    public void createOrder(OrderDTO orderDTO) {
        Order order  = new Order();
        Discount discount  = new Discount();

        discount.setId(orderDTO.getDiscountId());

        order.setId(null);
        order.setDiscount(discount);
        order.setDelivery(orderDTO.getDelivery());

        List<OrderItem> orderItemList = new ArrayList<>();

        for(OrderItemDTO orderItemDTO : orderDTO.getOrderItemDTOList()) {
            OrderItem orderItem = new OrderItem();
            Order order1 = new Order();
            Menu menu1 = new Menu();

            order1.setId(orderItemDTO.getOrderId());
            menu1.setId(orderItemDTO.getMenuId());

            orderItem.setId(orderItemDTO.getId());
            orderItem.setOrder(order1);
            orderItem.setMenu(menu1);

            orderItemList.add(orderItem);
        }
        order.setOrderItems(orderItemList);

        orderRepository.save(order);
    }

    public void cancelOrder(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        String delivery = order.get().getDelivery();

        if(delivery.equals("주문")) {
            orderRepository.deleteById(orderId);
        } else {
            // 취소 안되는 로직 작성
        }
    }

    public void updateOrderDelivery(Long orderId, String orderDelivery) {
        orderRepository.updateOrderDelivery(orderId, orderDelivery);
    }

}
