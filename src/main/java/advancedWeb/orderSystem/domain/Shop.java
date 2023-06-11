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

    @Column(name = "NAME")
    private String name;

    @Embedded
    private Address address;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "OPEN_TIME")
    private LocalDateTime openTime;

    @Column(name = "CLOSE_TIME")
    private LocalDateTime closeTime;
}
