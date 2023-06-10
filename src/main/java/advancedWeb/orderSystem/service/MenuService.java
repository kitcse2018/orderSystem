package advancedWeb.orderSystem.service;

import advancedWeb.orderSystem.dto.MenuDTO;
import advancedWeb.orderSystem.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void createMenu(MenuDTO menuDTO) {
        menuRepository.save();
    }

    public void updateMenu(MenuDTO menuDTO) {
        menuRepository.save();
    }

}
