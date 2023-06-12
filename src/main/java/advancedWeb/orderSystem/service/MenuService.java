package advancedWeb.orderSystem.service;

import advancedWeb.orderSystem.domain.Menu;
import advancedWeb.orderSystem.dto.MenuDTO;
import advancedWeb.orderSystem.repository.MenuRepository;
import advancedWeb.orderSystem.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void createMenu(MenuDTO menuDTO) {
        Menu menu = EntityConverter.toMenu(menuDTO);
        menuRepository.save(menu);
    }

    public void updateMenu(MenuDTO menuDTO) {
        Menu menu = EntityConverter.toMenu(menuDTO);
        menuRepository.updateMenu(menu);
    }

    /***
     * 메뉴 조회
     * @return List
     */
    public List<Menu> findAll(){
        return menuRepository.findAll();
    }

    public Integer searchMenuQuantity(Long menuId) {
        Optional<Menu> menu = menuRepository.findById(menuId);
        Integer menuQuantity = menu.get().getQuantity();
        return menuQuantity;
    }

    /***
     * 메뉴 이름으로 메뉴 조회
     * @param menuDTO
     * @return Menu
     */
    public boolean findByName(MenuDTO menuDTO) {
        Menu menu = EntityConverter.toMenu(menuDTO);
        List<Menu> findMenu = menuRepository.findByName(menu);
        if(findMenu.isEmpty()) {
            return false;
        }
        return true;
    }
}
