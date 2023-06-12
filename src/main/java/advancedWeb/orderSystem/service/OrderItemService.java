package advancedWeb.orderSystem.service;

import advancedWeb.orderSystem.domain.OrderItem;
import advancedWeb.orderSystem.dto.OrderItemDTO;
import advancedWeb.orderSystem.repository.OrderItemRepository;
import advancedWeb.orderSystem.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Transactional
    public void save(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = EntityConverter.toOrderItem(orderItemDTO);
        orderItemRepository.save(orderItem);
    }
}
