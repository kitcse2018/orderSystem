package advancedWeb.orderSystem.dto;

import lombok.Data;

@Data
public class OrderItemDTO {

    private Long id;
    private Long orderId;
    private Long menuId;
    private Integer amount;
}
