package advancedWeb.orderSystem.repository;

import advancedWeb.orderSystem.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
