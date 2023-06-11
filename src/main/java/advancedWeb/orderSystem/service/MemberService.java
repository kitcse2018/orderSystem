package advancedWeb.orderSystem.service;

import advancedWeb.orderSystem.domain.Member;
import advancedWeb.orderSystem.dto.MemberDTO;
import advancedWeb.orderSystem.exception.customExceptions.MemberException;
import advancedWeb.orderSystem.repository.MemberRepository;
import advancedWeb.orderSystem.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void saveMember(MemberDTO memberDTO) {
        Member member = EntityConverter.toMember(memberDTO);
        memberRepository.save(member);
    }

    /**
     * 로그인
     * @param memberDTO 로그인 시도하는 회원 정보
     * @return ResponseEntity (message, (OK || BAD_REQUEST))
     */
    public ResponseEntity<Object> login(MemberDTO memberDTO){ // 여기를 getMemberById로 바꾸고 Controller에서 로직 작성
        Member member = EntityConverter.toMember(memberDTO);
        Optional<Member> findMember = memberRepository.findById(member.getId());
        if(findMember.isPresent()){
            if(findMember.get().getPassword().equals(member.getPassword())){
                return new ResponseEntity("로그인 성공", HttpStatus.OK);
            }else{
                // 비밀번호가 일치하지 않음
                // throw new MemberException("비밀번호가 일치하지 않습니다.");
                return new ResponseEntity("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
            }
        }else{
            // 존재하는 회원이 아님
            return new ResponseEntity("존재하지 않는 회원입니다.", HttpStatus.BAD_REQUEST);
        }
    }
}
