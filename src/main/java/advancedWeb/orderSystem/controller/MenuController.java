package advancedWeb.orderSystem.controller;

import advancedWeb.orderSystem.dto.MenuDTO;
import advancedWeb.orderSystem.exception.customExceptions.MenuException;
import advancedWeb.orderSystem.service.MenuService;
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
        try{
            menuService.createMenu(menuDTO);
        }catch (Exception e) {
            throw new MenuException("메뉴 생성 실패");
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateMenu(@RequestBody MenuDTO menuDTO) {
        try{
            menuService.updateMenu(menuDTO);
        }catch (Exception e) {
            throw new MenuException("메뉴 수정 실패");
        }
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
