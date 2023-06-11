package advancedWeb.orderSystem.controller;

import advancedWeb.orderSystem.domain.Member;
import advancedWeb.orderSystem.dto.MemberDTO;
import advancedWeb.orderSystem.service.MemberService;
import advancedWeb.orderSystem.web.SessionConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // 회원가입 페이지 Get 요청
    /*@GetMapping("/signUp")


    // 회원가입 Post 요청
    /*@PostMapping("/signUp")
    public void signUp() {
        memberService.signUp();
    }*/

    // 로그인 페이지 Get 요청
    public String login(@ModelAttribute("member") MemberDTO memberDTO) {
        return "login";
    }

    // 로그인 Post 요청
    @PostMapping("/login")
    public ResponseEntity<Object> login(@Validated @ModelAttribute("member") MemberDTO memberDTO,
                                BindingResult bindingResult,
                                HttpServletRequest request) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity("로그인 실패", HttpStatus.BAD_REQUEST);
        }

        // 로그인 성공
        ResponseEntity<Object> responseEntity = memberService.login(memberDTO);

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, memberDTO.getId());

        // redirect 후에 위치 설정 해줘야 할 듯 (로그인 성공 시 메인 페이지로 이동)
        return responseEntity;
    }
}
