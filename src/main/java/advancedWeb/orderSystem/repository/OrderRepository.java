package advancedWeb.orderSystem.repository;

import advancedWeb.orderSystem.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Modifying
    @Query("update Order o set o.delivery = :orderDelivery where o.id = :orderId")
    void updateOrderDelivery(@Param("orderId") Long orderId,
                             @Param("orderDelivery") String orderDelivery);
    List<Order> findAllByDelivery(String delivery);

}
