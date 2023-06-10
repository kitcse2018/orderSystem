package advancedWeb.orderSystem.repository;

import advancedWeb.orderSystem.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
