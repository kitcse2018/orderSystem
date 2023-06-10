package advancedWeb.orderSystem.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Discount {
    @Id
    @GeneratedValue
    @Column(name = "DISCOUNT_ID")
    private Long id;

    // 할인 금액이 비율로 적용 되는지 판별하기 위해 (정률 할인 시 %로 할인)
    private Boolean isRate;

    // 할인 금액 혹은 비율
    private Integer discountPrice;
}
