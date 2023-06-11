package advancedWeb.orderSystem.exception;

import advancedWeb.orderSystem.exception.customExceptions.MemberException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class CustomExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try{
            if(ex instanceof IllegalArgumentException){
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage()); // 이 부분 변경
                return new ModelAndView();
            }else if(ex instanceof MemberException){
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage()); // 이 부분 변경
                return new ModelAndView();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
