package advancedWeb.orderSystem.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "DELIVERY")
    private String delivery;

    @Column(name="TOTAL_PRICE")
    private Integer totalPrice;

    @Column(name="ORDER_MEMBER_ID")
    private Long orderMemberId;

    @Column(name="IS_CONTAIN_MAIN")
    private Boolean isContainMain;

    @Column(name="CREATION_TIME")
    private LocalDateTime creationTime;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

}
