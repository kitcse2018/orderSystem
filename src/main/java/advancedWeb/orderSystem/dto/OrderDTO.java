package advancedWeb.orderSystem.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private String delivery;
    private Integer totalPrice;
    private Long orderMemberId;
    private List<OrderItemDTO> orderItemDTOList = new ArrayList<>();
}
