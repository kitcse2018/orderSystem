package advancedWeb.orderSystem.controller;

import advancedWeb.orderSystem.domain.Menu;
import advancedWeb.orderSystem.dto.MenuDTO;
import advancedWeb.orderSystem.exception.customExceptions.MenuException;
import advancedWeb.orderSystem.service.MenuService;
import advancedWeb.orderSystem.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/getMenu")
    public ResponseEntity<Object> getMenu() {
        try{
            return ResponseEntity.ok().body(menuService.findAll());
        }catch(Exception e) {
            throw new MenuException("메뉴 조회 실패");
        }
    }


    @PostMapping("/create")
    public ResponseEntity<Object> createMenu(@RequestBody MenuDTO menuDTO) {
        if(isExistMenu(menuDTO)) {
            throw new MenuException("이미 존재하는 메뉴입니다.");
        }
        menuService.createMenu(menuDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateMenu(@RequestBody MenuDTO menuDTO) {
        if(isExistMenu(menuDTO)) {
            throw new MenuException("이미 존재하는 메뉴 이름입니다.");
        }
        menuService.updateMenu(menuDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchMenuQuantity(@RequestParam("menuId") Long menuId) {
        try {
            menuService.searchMenuQuantity(menuId);
        } catch (Exception e) {
            throw new MenuException("찾는 메뉴가 없습니다.");
        }
        return ResponseEntity.ok().build();
    }

    public boolean isExistMenu(MenuDTO menuDTO) {
        return menuService.findByName(menuDTO);
    }

    @ExceptionHandler(MenuException.class)
    public ResponseEntity<Object> handleMenuException(MenuException e) {
        printExceptionInfo(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> exHandler(RuntimeException e){
        printExceptionInfo(e.getMessage());
        return ResponseEntity.badRequest().body("예기치 못한 오류가 발생했습니다.");
    }

    public void printExceptionInfo(String message){
        System.out.println("=============================================");
        System.out.println("MenuController printExceptionInfo");
        System.out.println("Exception message = " + message);
        System.out.println("=============================================");
    }
}
