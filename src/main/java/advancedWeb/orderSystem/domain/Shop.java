package advancedWeb.orderSystem.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Shop {
    @Id
    @GeneratedValue
    @Column(name = "SHOP_ID")
    private Long id;

    // 가게 상호
    private String name;

    // 가게 주소
    @Embedded
    private Address address;

    // 가게 전화번호
    private String number;

    // 가게 시작시간
    private LocalDateTime openTime;

    // 가게 종료시간
    private LocalDateTime closeTime;
}
