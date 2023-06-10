package advancedWeb.orderSystem.repository;

import advancedWeb.orderSystem.domain.Discount;
import advancedWeb.orderSystem.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {

    @Modifying
    @Query("update Discount d set d.isRate = :#{#Discount.rate}, d.discountPrice = :#{#Discount.discountPrice} where d.id = :#{#Discount.id}")
    void updateDiscount(@Param("Discount") Discount discount);
}
