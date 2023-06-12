package advancedWeb.orderSystem.controller;

import advancedWeb.orderSystem.dto.DiscountDTO;
import advancedWeb.orderSystem.exception.customExceptions.DiscountException;
import advancedWeb.orderSystem.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discount")
public class DiscountController {

    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @PutMapping
    public ResponseEntity<Object> updateDiscount(DiscountDTO discountDTO) {
        try{
            discountService.updateDiscount(discountDTO);
        }catch(Exception e) {
            throw new DiscountException("할인 정보 수정 실패");
        }
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(DiscountException.class)
    public ResponseEntity<Object> handleDiscountException(DiscountException e) {
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
