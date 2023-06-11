package advancedWeb.orderSystem.exception.customExceptions;

public class MemberException extends RuntimeException{

    private static final String signupFail = "회원가입 실패";
    private static final String loginFail = "로그인 실패";
    private static final String nonExistUser = "존재하지 않는 회원입니다";

    public MemberException() {
        super();
    }

    public MemberException(String message) {
        super(message);
    }
}
