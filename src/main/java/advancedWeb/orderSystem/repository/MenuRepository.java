package advancedWeb.orderSystem.repository;

import advancedWeb.orderSystem.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Modifying
    @Query("update Menu m set m.name = :#{#Menu.name}, m.price = :#{#menu.price}, m.quantity = :#{#menu.quantity}, m.pictureUrl = :#{#menu.pictureUrl}, m.info = :#{#menu.info}, m.type = :#{#menu.type} where m.id = :#{#menu.id}")
    void updateMenu(@Param("Menu") Menu menu);
}
