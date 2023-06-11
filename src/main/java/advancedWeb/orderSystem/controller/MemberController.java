package advancedWeb.orderSystem.controller;

import advancedWeb.orderSystem.domain.Member;
import advancedWeb.orderSystem.dto.MemberDTO;
import advancedWeb.orderSystem.exception.customExceptions.MemberException;
import advancedWeb.orderSystem.service.MemberService;
import advancedWeb.orderSystem.web.SessionConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // *************************** test ***************************

    @GetMapping("/login")
    public ResponseEntity<Object> login() {
        System.out.println("로그인 페이지 요청");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/test")
    public ResponseEntity<Object> test() {
        System.out.println("test");
        return ResponseEntity.ok().build();
    }

    // *************************** end of test ***************************

    // 회원가입 Post 요청
    @PostMapping("/signUp")
    public ResponseEntity<Object> signUp(@RequestBody MemberDTO memberDTO) {
        System.out.println("회원가입 요청");
        try{
            memberService.saveMember(memberDTO);
        }catch (Exception e) {
            throw new MemberException("회원가입 실패");
        }
        return ResponseEntity.ok().build();
    }

    // 로그인 Post 요청
    @PostMapping("/login")
    public ResponseEntity<Object> login(@Validated @RequestBody MemberDTO memberDTO,
                                BindingResult bindingResult,
                                HttpServletRequest request) {
        try{
            if(bindingResult.hasErrors()) {
                return ResponseEntity.badRequest().body("로그인 실패");
            }

            Member findMember = memberService.getMemberById(memberDTO.getId());

            if(findMember == null) {
                throw new MemberException("존재하지 않는 회원입니다.");
            }

            if(!findMember.getPassword().equals(memberDTO.getPassword())) {
                throw new MemberException("비밀번호가 일치하지 않습니다.");
            }

            // 로그인 성공
            HttpSession session = request.getSession();
            session.setAttribute(SessionConst.LOGIN_MEMBER, memberDTO.getId());

            // redirect 후에 위치 설정 해줘야 할 듯 (로그인 성공 시 메인 페이지로 이동)
            // 아니면 Front End에서 redirect 해줘야 할 듯
            return ResponseEntity.ok().build();

        }catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @ExceptionHandler(MemberException.class)
    public ResponseEntity<Object> memberExHandler(MemberException e){
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
