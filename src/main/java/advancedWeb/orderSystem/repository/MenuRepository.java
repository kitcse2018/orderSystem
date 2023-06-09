package advancedWeb.orderSystem.repository;

import advancedWeb.orderSystem.domain.Menu;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Modifying
    @Query("update Menu m set m.name = :#{#Menu.name}, m.price = :#{#Menu.price}, m.quantity = :#{#Menu.quantity}, m.pictureUrl = :#{#Menu.pictureUrl}, m.info = :#{#Menu.info}, m.type = :#{#Menu.type} where m.id = :#{#Menu.id}")
    void updateMenu(@Param("Menu") Menu menu);

    @Modifying
    @Query("update Menu m set m.discountId = :#{#Menu.discountId} where m.id = :#{#Menu.id}")
    void updateDiscount(@Param("Menu") Menu menu);

    @Query("select m from Menu m where m.name = :#{#Menu.name}")
    List<Menu> findByName(@Param("Menu") Menu menu);

}
