package advancedWeb.orderSystem.repository;

import advancedWeb.orderSystem.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
