package advancedWeb.orderSystem.domain;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
//주문 시스템 요구 사항 중 가게 정보에 주소가 포함 됨
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
