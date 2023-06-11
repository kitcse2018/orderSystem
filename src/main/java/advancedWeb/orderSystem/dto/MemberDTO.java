package advancedWeb.orderSystem.dto;

import advancedWeb.orderSystem.domain.RoleType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class MemberDTO {
    private Long id;
    private String password;
    private String name;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
}
