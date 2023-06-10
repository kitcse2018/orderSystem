package advancedWeb.orderSystem.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorColumn(name = "M_TYPE")
public class Menu {
    @Id
    @GeneratedValue
    @Column(name = "MENU_ID")
    private Long id;

    // 메뉴 이름
    private String name;

    // 메뉴 가격
    private Integer price;

    // 메뉴 판매 수량
    private Integer quantity;

    // 메뉴 사진
    private String pictureUrl;

    // 메뉴 상세 설명
    private String info;

    // 메뉴 타입 (M: 메인메뉴, S: 사이드메뉴)
    private String type;
}
