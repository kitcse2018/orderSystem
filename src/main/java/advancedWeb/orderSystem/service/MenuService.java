package advancedWeb.orderSystem.service;

import advancedWeb.orderSystem.domain.Menu;
import advancedWeb.orderSystem.dto.MenuDTO;
import advancedWeb.orderSystem.repository.MenuRepository;
import advancedWeb.orderSystem.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
}
