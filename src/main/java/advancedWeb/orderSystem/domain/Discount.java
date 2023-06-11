package advancedWeb.orderSystem.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "DISCOUNT")
public class Discount {
    @Id
    @GeneratedValue
    @Column(name = "DISCOUNT_ID")
    private Long id;

    @Column(name = "IS_RATE")
    private Boolean isRate;

    @Column(name = "DISCOUNT_PRICE")
    private Integer discountPrice;
}
