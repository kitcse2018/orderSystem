package advancedWeb.orderSystem.repository;

import advancedWeb.orderSystem.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
