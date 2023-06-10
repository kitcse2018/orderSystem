package advancedWeb.orderSystem.dto;

import advancedWeb.orderSystem.domain.DeliveryStatus;
import advancedWeb.orderSystem.domain.Order;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class DeliveryDTO {
    private Long id;
    private Order order;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
