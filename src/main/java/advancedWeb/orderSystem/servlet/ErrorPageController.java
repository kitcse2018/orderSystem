package advancedWeb.orderSystem.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class ErrorPageController {
    @RequestMapping("/error")
    public String errorPage(){
        log.info("errorPage() called");
        return "error";
    }
}
