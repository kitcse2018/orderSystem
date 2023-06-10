package advancedWeb.orderSystem.controller;

import advancedWeb.orderSystem.dto.MenuDTO;
import advancedWeb.orderSystem.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping()
    public void createMenu(@RequestBody MenuDTO menuDTO) {
        menuService.createMenu(menuDTO);
    }

    @PutMapping()
    public void updateMenu(@RequestBody MenuDTO menuDTO) {
        menuService.updateMenu(menuDTO);
    }

}
