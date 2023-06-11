package advancedWeb.orderSystem.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@DiscriminatorColumn(name = "M_TYPE")
public class Menu {
    @Id
    @GeneratedValue
    @Column(name = "MENU_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "PICTURE_URL")
    private String pictureUrl;

    @Column(name = "INFO")
    private String info;

    @Column(name = "TYPE")
    private String type;

    // Menu와 OrderItem 간의 관계 설정
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
}
