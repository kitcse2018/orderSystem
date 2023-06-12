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
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /***
     * 회원가입 로직
     * @Param memberDTO 회원가입을 시도하는 회원의 정보
     * @return void
     * */
    @Transactional
    public void saveMember(MemberDTO memberDTO) {
        Member member = EntityConverter.toMember(memberDTO);
        memberRepository.save(member);
    }


    /***
     * 로그인 시 회원 조회
     * @param id 로그인을 시도하는 회원의 아이디
     * @return id에 해당하는 회원
     * @Nullable
     */
    @Transactional
    public Member getMemberById(Long id){
        Optional<Member> findMember = memberRepository.findById(id);
        if(findMember.isPresent()){
            return findMember.get();
        }
        return null;
    }
}
