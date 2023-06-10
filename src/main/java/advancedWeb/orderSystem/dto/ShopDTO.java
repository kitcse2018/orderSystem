package advancedWeb.orderSystem.dto;

import advancedWeb.orderSystem.domain.Address;
import lombok.Data;

import javax.persistence.Embedded;
import java.time.LocalDateTime;

@Data
public class ShopDTO {
    private Long id;
    private String name;
    @Embedded
    private Address address;
    private String number;
    private LocalDateTime openTime;
    private LocalDateTime closeTime;
}
